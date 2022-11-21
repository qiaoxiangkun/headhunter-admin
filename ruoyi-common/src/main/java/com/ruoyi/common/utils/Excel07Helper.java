package com.ruoyi.common.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Excel07Helper {
    public static String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";
    public static int DEFAULT_COLOUMN_WIDTH = 17;

    /**
     * 导出Excel 97(.xls)格式 ，少量数据
     *
     * @param title       标题行
     * @param headMap     属性-列名
     * @param jsonArray   数据集
     * @param datePattern 日期格式，null则用默认日期格式
     * @param colWidth    列宽 默认 至少17个字节
     * @param out         输出流
     */
    public static void exportExcel(String title, Map<String, String> headMap, JSONArray jsonArray, String datePattern, int colWidth, OutputStream out) {
        if (datePattern == null) {
            datePattern = DEFAULT_DATE_PATTERN;
        }
        // 声明一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        workbook.createInformationProperties();
        HSSFSheet sheet = workbook.createSheet();
        //设置列宽
        int minBytes = colWidth < DEFAULT_COLOUMN_WIDTH ? DEFAULT_COLOUMN_WIDTH : colWidth;//至少字节数
        int[] arrColWidth = new int[headMap.size()];
        // 产生表格标题行,以及设置列宽
        String[] properties = new String[headMap.size()];
        String[] headers = new String[headMap.size()];
        int ii = 0;
        for (Iterator<String> iter = headMap.keySet().iterator(); iter
                .hasNext(); ) {
            String fieldName = iter.next();

            properties[ii] = fieldName;
            headers[ii] = fieldName;

            int bytes = fieldName.getBytes().length;
            arrColWidth[ii] = bytes < minBytes ? minBytes : bytes;
            sheet.setColumnWidth(ii, arrColWidth[ii] * 256);
            ii++;
        }
        // 遍历集合数据，产生数据行
        int rowIndex = 0;
        for (Object obj : jsonArray) {
            if (rowIndex == 65535 || rowIndex == 0) {
                if (rowIndex != 0) {
                    sheet = workbook.createSheet();
                }

                HSSFRow titleRow = sheet.createRow(0);
                titleRow.createCell(0).setCellValue(title);
                sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, headMap.size() - 1));

                HSSFRow headerRow = sheet.createRow(1);
                for (int i = 0; i < headers.length; i++) {
                    headerRow.createCell(i).setCellValue(headers[i]);

                }
                rowIndex = 2;
            }
            JSONObject jo = (JSONObject) JSONObject.toJSON(obj);
            HSSFRow dataRow = sheet.createRow(rowIndex);
            for (int i = 0; i < properties.length; i++) {
                HSSFCell newCell = dataRow.createCell(i);

                Object o = jo.get(properties[i]);
                String cellValue = "";
                if (o == null) {
                    cellValue = "";
                } else if (o instanceof Date) {
                    cellValue = new SimpleDateFormat(datePattern).format(o);
                } else {
                    cellValue = o.toString();
                }

                newCell.setCellValue(cellValue);
            }
            rowIndex++;
        }

        try {
            workbook.write(out);
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void exportExcelXMoreSheet(String title, List<String> listSheetName, List<Map<String,String>> listHeadMap, List<JSONArray> listJa, List<Integer> listColWidth
            , List<Map<String,Short>> listColorHeadMap, HttpServletResponse response){

        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            // 声明一个工作薄
            SXSSFWorkbook workbook = new SXSSFWorkbook(1000);//缓存
            int index = 0;
            for (String sheetName : listSheetName) {
                Excel07Helper.exportExcelX(workbook,sheetName,listHeadMap.get(index), listJa.get(index), null
                        , (listColWidth == null ? 0 : listColWidth.get(index)),(listColorHeadMap == null ? null : listColorHeadMap.get(index)), os);
                index++;
            }
            workbook.write(os);
            workbook.close();
            workbook.dispose();
            byte[] content = os.toByteArray();
            InputStream is = new ByteArrayInputStream(content);

            // 设置response参数，可以打开下载页面
            response.reset();
            response.setHeader("Content-disposition", String.format("attachment; filename=\"%s\"", title));
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
            response.setContentLength(content.length);
            ServletOutputStream outputStream = response.getOutputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            BufferedOutputStream bos = new BufferedOutputStream(outputStream);
            byte[] buff = new byte[8192];
            int bytesRead;
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);

            }

            bis.close();
            bos.close();
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 导出Excel 2007 OOXML (.xlsx)格式
     *
     * @param headMap     属性-列头
     * @param jsonArray   数据集
     * @param datePattern 日期格式，传null值则默认 年月日
     * @param colWidth    列宽 默认 至少17个字节
     * @param out         输出流
     */
    public static void exportExcelX(SXSSFWorkbook workbook, String sheetName, Map<String, String> headMap, JSONArray jsonArray, String datePattern, int colWidth, Map<String,Short> colorHeadMap, OutputStream out) {
        if (datePattern == null) {
            datePattern = DEFAULT_DATE_PATTERN;
        }
        ZipSecureFile.setMinInflateRatio(-1.0d);
        workbook.setCompressTempFiles(true);
        DataFormat format = workbook.createDataFormat();

        // 生成一个(带标题)表格
        SXSSFSheet sheet =ConvertHelper.checkStr(sheetName) ? workbook.createSheet(sheetName) : workbook.createSheet();
        //设置列宽
        int minBytes = colWidth < DEFAULT_COLOUMN_WIDTH ? DEFAULT_COLOUMN_WIDTH : colWidth;//至少字节数
        int[] arrColWidth = new int[headMap.size()];
        // 产生表格标题行,以及设置列宽
        String[] properties = new String[headMap.size()];
        String[] headers = new String[headMap.size()];
        short[] headerColors = null;
        if(colorHeadMap != null){
            headerColors = new short[colorHeadMap.size()];
            int iiC = 0;
            for(Map.Entry<String,Short> item : colorHeadMap.entrySet()){
                headerColors[iiC] = item.getValue();
                iiC++;
            }
        }
        int ii = 0;
        for (Iterator<String> iter = headMap.keySet().iterator(); iter.hasNext(); ) {
            String fieldName = iter.next();

            properties[ii] = fieldName;
            headers[ii] = headMap.get(fieldName);

            int bytes = fieldName.getBytes().length;
            arrColWidth[ii] = bytes < minBytes ? minBytes : bytes;
            sheet.setColumnWidth(ii, arrColWidth[ii] * 256);
            ii++;
        }
        // 遍历集合数据，产生数据行
        int rowIndex = 0;
        if(jsonArray.size() <= 2000){
            if (rowIndex == 0) {
                SXSSFRow headerRow = sheet.createRow(0);
                for (int i = 0; i < headers.length; i++) {
                    headerRow.createCell(i).setCellValue(headers[i]);
                }
                rowIndex = 1;
            }
            //2000行以下走此逻辑为了加个sytel中的color
            for (Object obj : jsonArray) {
                JSONObject jo = (JSONObject) JSONObject.toJSON(obj);
                SXSSFRow dataRow = sheet.createRow(rowIndex);
                for (int i = 0; i < properties.length; i++) {
                    CellStyle style = workbook.createCellStyle();
                    SXSSFCell newCell = dataRow.createCell(i);
                    Object o = jo.get(properties[i]);
                    if(headerColors != null) {
                        style.setFillForegroundColor(headerColors[i]);
                        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
                        style.setBorderBottom(BorderStyle.THIN); //下边框
                        style.setBorderLeft(BorderStyle.THIN);//左边框
                        style.setBorderTop(BorderStyle.THIN);//上边框
                        style.setBorderRight(BorderStyle.THIN);//右边框
                    }
                    if (o == null) {
                        newCell.setCellValue("");
                        newCell.setCellStyle(style);
                    } else if (o instanceof Date) {
                        style.setDataFormat(format.getFormat("yyyy-MM-dd"));
                        newCell.setCellValue(ConvertHelper.toDate(o));
                        newCell.setCellStyle(style);
                    }
                    else if(o instanceof Integer){
                        newCell.setCellValue(ConvertHelper.toInt32(o));
                        newCell.setCellStyle(style);
                    }
                    else if(o instanceof BigDecimal){
                        double doubleVal = ((BigDecimal) o).doubleValue();
                        style.setDataFormat(format.getFormat("#,##0.00"));
                        newCell.setCellValue(doubleVal);
                        newCell.setCellStyle(style);
                    }
                    else if (o instanceof Float || o instanceof Double ) {
                        newCell.setCellValue(ConvertHelper.toDouble(o));
                        newCell.setCellStyle(style);
                    } else {
                        String cellValue = o.toString();
                        String regx = "^\\d+\\.?\\d*\\%?$";
                        if (cellValue.trim().matches(regx) && cellValue.indexOf("%") > 0) {
                            newCell.setCellValue(Double.parseDouble(o.toString().replace("%", "")) / 100);
                            style.setDataFormat(HSSFDataFormat.getBuiltinFormat("0%"));
                            newCell.setCellStyle(style);
                        } else {
                            newCell.setCellValue(cellValue);
                            newCell.setCellStyle(style);
                        }
                    }
                }
                rowIndex++;
            }
        }else {
            CellStyle style = workbook.createCellStyle();
            CellStyle stylePercent = workbook.createCellStyle();
            CellStyle styleInteger = workbook.createCellStyle();
            for (Object obj : jsonArray) {
                if (rowIndex == 65535 || rowIndex == 0) {
                    if (rowIndex != 0) {
                        sheet = workbook.createSheet();
                    }

                    SXSSFRow headerRow = sheet.createRow(0);
                    for (int i = 0; i < headers.length; i++) {
                        headerRow.createCell(i).setCellValue(headers[i]);
                    }
                    rowIndex = 1;
                }
                JSONObject jo = (JSONObject) JSONObject.toJSON(obj);
                SXSSFRow dataRow = sheet.createRow(rowIndex);
                for (int i = 0; i < properties.length; i++) {
                    SXSSFCell newCell = dataRow.createCell(i);
                    Object o = jo.get(properties[i]);
                    if (o == null) {
                        newCell.setCellValue("");
                        //style.setDataFormat(HSSFDataFormat.getBuiltinFormat("General"));
                        newCell.setCellStyle(style);
                    } else if (o instanceof Date) {
                        style.setDataFormat(format.getFormat("yyyy-MM-dd"));
                        newCell.setCellValue(ConvertHelper.toDate(o));
                        newCell.setCellStyle(style);
                    } else if (o instanceof Integer) {
                        newCell.setCellValue(ConvertHelper.toInt32(o));
                        styleInteger.setDataFormat(HSSFDataFormat.getBuiltinFormat("0"));
                        newCell.setCellStyle(styleInteger);
                    } else if (o instanceof BigDecimal) {
                        double doubleVal = ((BigDecimal) o).doubleValue();
                        style.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));
                        newCell.setCellValue(doubleVal);
                        newCell.setCellStyle(style);
                    } else if (o instanceof Float || o instanceof Double) {
                        newCell.setCellValue(ConvertHelper.toDouble(o));
                        style.setDataFormat(format.getFormat("#,##0.00"));
                        newCell.setCellStyle(style);
                    } else {
                        String cellValue = o.toString();
                        String regx = "^\\d+\\.?\\d*\\%?$";
                        if (cellValue.trim().matches(regx) && cellValue.indexOf("%") > 0) {
                            newCell.setCellValue(Double.parseDouble(o.toString().replace("%", "")) / 100);
                            stylePercent.setDataFormat(format.getFormat("0%"));
                            newCell.setCellStyle(stylePercent);
                        } else {
                            newCell.setCellValue(cellValue);
                            //style.setDataFormat(HSSFDataFormat.getBuiltinFormat("General"));
                            newCell.setCellStyle(style);
                        }
                    }
                }
                rowIndex++;
            }
        }
    }


    private static String toUtf8String(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 0 && c <= 255) {
                sb.append(c);
            } else {
                byte[] b;
                try {
                    b = Character.toString(c).getBytes("utf-8");
                } catch (Exception ex) {
                    System.out.println(ex);
                    b = new byte[0];
                }
                for (int j = 0; j < b.length; j++) {
                    int k = b[j];
                    if (k < 0) k += 256;
                    sb.append("%" + Integer.toHexString(k).toUpperCase());
                }
            }
        }
        return sb.toString();
    }

    public static void downloadExcelFile(String title, Map<String, String> headMap, JSONArray ja, HttpServletResponse response) {
        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            // 声明一个工作薄
            SXSSFWorkbook workbook = new SXSSFWorkbook(1000);//缓存
            Excel07Helper.exportExcelX(workbook,"",headMap, ja, null, 0,null, os);
            workbook.write(os);
            workbook.close();
            workbook.dispose();
            byte[] content = os.toByteArray();
            InputStream is = new ByteArrayInputStream(content);
            // 设置response参数，可以打开下载页面
            response.reset();

            /*response.setHeader("Content-disposition", String.format("attachment; filename=\"%s\"", title));
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");*/
            response.setHeader("Content-disposition", String.format("attachment; filename=\"%s\"",toUtf8String(title)));
            response.setContentType("application/octet-stream");
            response.setContentLength(content.length);
            ServletOutputStream outputStream = response.getOutputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            BufferedOutputStream bos = new BufferedOutputStream(outputStream);
            byte[] buff = new byte[8192];
            int bytesRead;
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);

            }
            bis.close();
            bos.close();
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void downloadExcelFileWithColBackGroundColor(String title, Map<String, String> headMap, JSONArray ja, Map<String,Short> colorHeadMap, HttpServletResponse response) {
        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            // 声明一个工作薄
            SXSSFWorkbook workbook = new SXSSFWorkbook(1000);//缓存
            Excel07Helper.exportExcelX(workbook,"",headMap, ja, null, 0,colorHeadMap, os);
            workbook.write(os);
            workbook.close();
            workbook.dispose();
            byte[] content = os.toByteArray();
            InputStream is = new ByteArrayInputStream(content);
            // 设置response参数，可以打开下载页面
            response.reset();

            response.setHeader("Content-disposition", String.format("attachment; filename=\"%s\"", title));
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
            response.setContentLength(content.length);
            ServletOutputStream outputStream = response.getOutputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            BufferedOutputStream bos = new BufferedOutputStream(outputStream);
            byte[] buff = new byte[8192];
            int bytesRead;
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);

            }
            bis.close();
            bos.close();
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
