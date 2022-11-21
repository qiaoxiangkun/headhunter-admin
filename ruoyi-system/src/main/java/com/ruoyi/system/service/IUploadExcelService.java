package com.ruoyi.system.service;

import org.apache.poi.ss.usermodel.Workbook;

import java.io.InputStream;
import java.util.List;

/**
 * @author : think$
 * @description: 上传文件
 */
public interface IUploadExcelService {

    List getBankListByExcel(InputStream in, String fileName) throws Exception;

    Workbook getWorkbook(InputStream inStr, String fileName) throws Exception;
}
