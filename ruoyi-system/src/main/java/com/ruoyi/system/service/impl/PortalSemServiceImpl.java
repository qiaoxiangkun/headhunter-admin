package com.ruoyi.system.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.*;
import com.ruoyi.system.domain.Client;
import com.ruoyi.system.domain.PortalClientExt;
import com.ruoyi.system.mapper.ClientMapper;
import com.ruoyi.system.mapper.PortalClientExtMapper;
import com.ruoyi.system.service.ISysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PortalSemMapper;
import com.ruoyi.system.domain.PortalSem;
import com.ruoyi.system.service.IPortalSemService;
import com.ruoyi.common.core.text.Convert;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.springframework.transaction.annotation.Propagation.NOT_SUPPORTED;

/**
 * 线索Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-03
 */
@Service
public class PortalSemServiceImpl implements IPortalSemService 
{
    @Autowired
    private PortalSemMapper portalSemMapper;
    @Autowired
    private ISysConfigService configService;
    @Autowired
    PortalClientExtMapper portalClientExtMapper;
    @Autowired
    UploadExcelServiceImpl uploadExcelService;
    @Autowired
    ClientMapper clientMapper;
    @Autowired
    PortalClientExtServiceImpl portalClientExtService;
    /**
     * 查询线索
     * 
     * @param semId 线索主键
     * @return 线索
     */
    @Override
    public PortalSem selectPortalSemBySemId(Long semId)
    {
        return portalSemMapper.selectPortalSemBySemId(semId);
    }

    /**
     * 查询线索列表
     * 
     * @param portalSem 线索
     * @return 线索
     */
    @Override
    public List<PortalSem> selectPortalSemList(PortalSem portalSem)
    {
        return portalSemMapper.selectPortalSemList(portalSem);
    }

    /**
     * 新增线索
     * 
     * @param portalSem 线索
     * @return 结果
     */
    @Override
    public int insertPortalSem(PortalSem portalSem)
    {
        return portalSemMapper.insertPortalSem(portalSem);
    }

    /**
     * 修改线索
     * 
     * @param portalSem 线索
     * @return 结果
     */
    @Override
    public int updatePortalSem(PortalSem portalSem)
    {
        return portalSemMapper.updatePortalSem(portalSem);
    }

    /**
     * 批量删除线索
     * 
     * @param semIds 需要删除的线索主键
     * @return 结果
     */
    @Override
    public int deletePortalSemBySemIds(String semIds)
    {
        return portalSemMapper.deletePortalSemBySemIds(Convert.toStrArray(semIds));
    }

    /**
     * 删除线索信息
     * 
     * @param semId 线索主键
     * @return 结果
     */
    @Override
    public int deletePortalSemBySemId(Long semId)
    {
        return portalSemMapper.deletePortalSemBySemId(semId);
    }
    /**
     * 删除线索信息
     *
     * @param semIds 线索主键
     * @return 结果
     */
    @Override
    public int updatePortalSemBySemIds(String semIds)
    {
        return portalSemMapper.updatePortalSemBySemIds(Convert.toStrArray(semIds));
    }
    /**
     * 导入用户数据
     *
     * @param portalSemList 线索数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    @Override
    public String importUser(List<PortalSem> portalSemList, Boolean isUpdateSupport, String operName)
    {
        if (StringUtils.isNull(portalSemList) || portalSemList.size() == 0)
        {
            throw new ServiceException("导入B端线索数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        String password = configService.selectConfigByKey("sys.user.initPassword");
        /*for (SysUser user : userList)
        {
            try
            {
                // 验证是否存在这个用户
                SysUser u = userMapper.selectUserByLoginName(user.getLoginName());
                if (StringUtils.isNull(u))
                {
                    BeanValidators.validateWithException(validator, user);
                    user.setPassword(Md5Utils.hash(user.getLoginName() + password));
                    user.setCreateBy(operName);
                    this.insertUser(user);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、账号 " + user.getLoginName() + " 导入成功");
                }
                else if (isUpdateSupport)
                {
                    BeanValidators.validateWithException(validator, user);
                    checkUserAllowed(user);
                    checkUserDataScope(user.getUserId());
                    user.setUpdateBy(operName);
                    this.updateUser(user);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、账号 " + user.getLoginName() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、账号 " + user.getLoginName() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、账号 " + user.getLoginName() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
                log.error(msg, e);
            }
        }*/
        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new ServiceException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }

    /**
     * 每日信动线索数据导入
     * @param file
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String exportPortalSemExcel(MultipartFile file,HttpServletResponse response, HttpServletRequest request)throws Exception {
        InputStream inputStream = null;
        StringBuilder successMsg = new StringBuilder();
        try {
            inputStream = file.getInputStream();
            List<List<Object>> list = uploadExcelService.getBankListByExcel(inputStream, file.getOriginalFilename());
            inputStream.close();
            //页签容器
            //List<String[]>  tab=new ArrayList<>();
            //标题容器
            //List<String[]> title =new ArrayList<>();
            //数据容器顺序
            //List<String[]> dataOrder =new ArrayList<>();
            //数据容器
            JSONArray jsonData = new JSONArray();
            String companyNameStr="";
            for (int i = 0; i < list.size(); i++) {
                Map<String, Object> map = new LinkedHashMap<>();
                List<Object> lo = list.get(i);
                Client client=portalClientExtService.getClientByCompanyName(String.valueOf(lo.get(0)));
                if(list.get(0).size()==1){
                    //rnss系统匹配公司名称
                    if(client!=null){
                        //如果存在导出不存在Excel
                        //获取页签
                        //tab.add(publicStc.rankTab);
                        //获取标题  "用户编号","用户昵称","排名","总分数","榜单日期","变化趋势"
                        //title.add(publicStc.rankTitle);
                       // dataOrder.add(publicStc.rankOrderTitle);
                        map.put("companyName",String.valueOf(lo.get(0)));
                        companyNameStr+=lo.get(0)+"，";
                        jsonData.add(map);
                    }


                }else{
                    if(client==null){
                        PortalSem portalSem= new PortalSem();
                        portalSem.setCompanyName(String.valueOf(lo.get(0)));
                        List<PortalSem> portalSemList=portalSemMapper.selectPortalSemList(portalSem);

                        portalSem.setMobileNumber(String.valueOf(lo.get(1)));
                        portalSem.setName(String.valueOf(lo.get(2)));
                        portalSem.setCompanyName(String.valueOf(lo.get(0)));
                        portalSem.setRecruitPosition(String.valueOf(lo.get(3)));
                        portalSem.setSemType(Long.valueOf(1));
                        portalSem.setClueSource(Long.valueOf(2));
                        portalSem.setInputSource(Long.valueOf(2));
                        if(portalSemList.size()<=0){
                            portalSemMapper.insertPortalSem(portalSem);
                        }
                        PortalClientExt portalClientExt=new PortalClientExt();
                        portalClientExt.setSemId(portalSem.getSemId());
                        portalClientExt.setBusinessScope(String.valueOf(lo.get(10)));
                        portalClientExt.setCompanyIntroduce(String.valueOf(lo.get(15)));
                        portalClientExt.setCompanyState(String.valueOf(lo.get(8)));
                        portalClientExt.setCompanyType(String.valueOf(lo.get(6)));
                        portalClientExt.setCompanyWebsiteAddress(String.valueOf(lo.get(17)));
                        portalClientExt.setCreditCode(String.valueOf(lo.get(4)));
                        portalClientExt.setEstablishDate(String.valueOf(lo.get(7)));
                        portalClientExt.setIndustryCategory(String.valueOf(lo.get(13)));
                        portalClientExt.setLegalpersonName(String.valueOf(lo.get(5)));
                        portalClientExt.setMailbox(String.valueOf(lo.get(19)));
                        portalClientExt.setPlaceDistrict(String.valueOf(lo.get(12)));
                        portalClientExt.setPostalAddress(String.valueOf(lo.get(16)));
                        portalClientExt.setRegisteredAddress(String.valueOf(lo.get(11)));
                        portalClientExt.setRegisteredCapital(String.valueOf(lo.get(9)));
                        portalClientExt.setRevenueScale(String.valueOf(lo.get(14)));
                        portalClientExt.setShareholder(String.valueOf(lo.get(18)));
                        portalClientExt.setTeamPeople(Long.valueOf(String.valueOf(lo.get(20))));
                        //portalClientExt.setTeamPeople((Long) lo.get(20));
                        if(portalSemList.size()>0){
                            portalSem.setSemId(portalSemList.get(0).getSemId());
                            portalSemMapper.updatePortalSem(portalSem);
                            PortalClientExt portalClientExtModel=portalClientExtMapper.selectPortalClientExtBySemId(portalSem.getSemId());
                            if(portalClientExtModel!=null){
                                portalClientExt.setId(portalClientExtModel.getId());
                                portalClientExtMapper.updatePortalClientExt(portalClientExt);
                            }
                        }else{

                            portalClientExtMapper.insertPortalClientExt(portalClientExt);
                        }

                    }
                    }
            }
            if(jsonData.size()>0||list.get(0).size()==1){
                Map<String, String> headMap = new LinkedHashMap<>();
                headMap.put("companyName","公司名称");
                //导出excel
                String title = "重复公司名单.xlsx";
                request.setAttribute("logFileName", title);
                //Excel07Helper.downloadExcelFile(title, headMap, jsonData, response);
                //ExcelUtil.exportExcel(response,listMap,tab,title,dataOrder,DateUtils.getTime());
                successMsg.insert(0, "检索成功!重复公司： " + companyNameStr + "");
                return successMsg.toString();
            }
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + list.size() + " 条");
        } catch (IOException e) {
            throw new ServiceException(successMsg.toString());
        }
        return successMsg.toString();
    }


    /*@Override
    public String importPortalSemExcel() {
        return super.toString();
    }*/
}
