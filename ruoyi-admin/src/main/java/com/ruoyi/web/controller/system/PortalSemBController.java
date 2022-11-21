package com.ruoyi.web.controller.system;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.system.domain.PortalClientExt;
import com.ruoyi.system.domain.PortalSemFile;
import com.ruoyi.system.service.IPortalClientExtService;
import com.ruoyi.system.service.IPortalSemFileService;
import com.ruoyi.system.service.impl.UploadExcelServiceImpl;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.PortalSem;
import com.ruoyi.system.service.IPortalSemService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * B端线索Controller
 *
 * @author ruoyi
 * @date 2022-11-03
 */
@Controller
@RequestMapping("/system/semb")
public class PortalSemBController extends BaseController
{
    private String prefix = "system/semb";

    @Autowired
    private IPortalSemService portalSemService;
    @Autowired
    private IPortalSemFileService portalSemFileService;
    @Autowired
    private IPortalClientExtService portalClientExtService;
    @Autowired
    UploadExcelServiceImpl uploadExcelService;

    @RequiresPermissions("system:semb:view")
    @GetMapping()
    public String sem()
    {
        return prefix + "/semb";
    }

    /**
     * 查询线索列表
     */
    @RequiresPermissions("system:semb:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PortalSem portalSem)
    {
        startPage();
        portalSem.setSemType(Long.valueOf(1));
        List<PortalSem> list = portalSemService.selectPortalSemList(portalSem);
        for (PortalSem sem : list) {
            PortalSemFile portalSemFile=new PortalSemFile();
            portalSemFile.setSemId(sem.getSemId());
            sem.setPortalSemFileList(portalSemFileService.selectPortalSemFileList(portalSemFile));
            sem.setPortalClientExt(portalClientExtService.selectPortalClientExtBySemId(sem.getSemId()));
        }
        return getDataTable(list);
    }

    /**
     * 导出线索列表
     */
    @RequiresPermissions("system:semb:export")
    @Log(title = "线索", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PortalSem portalSem)
    {
        portalSem.setSemType(Long.valueOf(1));
        List<PortalSem> list = portalSemService.selectPortalSemList(portalSem);
        ExcelUtil<PortalSem> util = new ExcelUtil<PortalSem>(PortalSem.class);
        return util.exportExcel(list, "B端线索数据");
    }

    /**
     * 新增线索
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存线索
     */
    @RequiresPermissions("system:semb:add")
    @Log(title = "线索", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PortalSem portalSem)
    {
        portalSem.setClueSource((long) -1);
        portalSem.setInputSource((long) 1);
        portalSem.setSemType(Long.valueOf(1));
        return toAjax(portalSemService.insertPortalSem(portalSem));
    }

    /**
     * 修改线索
     */
    @RequiresPermissions("system:sem:edit")
    @GetMapping("/edit/{semId}")
    public String edit(@PathVariable("semId") Long semId, ModelMap mmap)
    {
        PortalSem portalSem = portalSemService.selectPortalSemBySemId(semId);
        mmap.put("portalSem", portalSem);
        return prefix + "/edit";
    }

    /**
     * 修改保存线索
     */
    @RequiresPermissions("system:semb:edit")
    @Log(title = "线索", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PortalSem portalSem)
    {
        return toAjax(portalSemService.updatePortalSem(portalSem));
    }

    /**
     * 删除线索
     */
    @RequiresPermissions("system:semb:remove")
    @Log(title = "线索", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(portalSemService.updatePortalSemBySemIds(ids));
    }

    @Log(title = "B端线索（每日信动线索数据导入）", businessType = BusinessType.IMPORT)
    @RequiresPermissions("system:semb:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, HttpServletResponse response, HttpServletRequest request) throws Exception
    {
        /*ExcelUtil<PortalSem> util = new ExcelUtil<PortalSem>(PortalSem.class);
        List<PortalSem> portalSemList = util.importExcel(file.getInputStream());
        String message = portalSemService.importUser(portalSemList, updateSupport, getLoginName());*/
        String messge= portalSemService.exportPortalSemExcel(file,response,request);
        return AjaxResult.success(messge);
    }
    @RequiresPermissions("system:semb:detail")
    @GetMapping("/detail/{semId}")
    public String detail(@PathVariable("semId") Long semId, ModelMap mmap)
    {
        PortalSem sem=portalSemService.selectPortalSemBySemId(semId);
        sem.setPortalClientExt(portalClientExtService.selectPortalClientExtBySemId(sem.getSemId()));
        mmap.put("operSem", sem);
        return prefix + "/detail";
    }
    /*@RequiresPermissions("system:user:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<PortalSem> util = new ExcelUtil<PortalSem>(PortalSem.class);
        return util.importTemplateExcel("B端线索");
    }*/
}
