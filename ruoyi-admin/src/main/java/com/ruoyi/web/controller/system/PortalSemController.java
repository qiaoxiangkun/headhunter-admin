package com.ruoyi.web.controller.system;

import java.util.List;

import com.ruoyi.system.domain.PortalSemFile;
import com.ruoyi.system.service.IPortalSemFileService;
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

/**
 * C端线索Controller
 * 
 * @author ruoyi
 * @date 2022-11-03
 */
@Controller
@RequestMapping("/system/sem")
public class PortalSemController extends BaseController
{
    private String prefix = "system/sem";

    @Autowired
    private IPortalSemService portalSemService;
    @Autowired
    private IPortalSemFileService portalSemFileService;

    @RequiresPermissions("system:sem:view")
    @GetMapping()
    public String sem()
    {
        return prefix + "/sem";
    }

    /**
     * 查询线索列表
     */
    @RequiresPermissions("system:sem:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PortalSem portalSem)
    {
        startPage();
        portalSem.setSemType(Long.valueOf(2));
        List<PortalSem> list = portalSemService.selectPortalSemList(portalSem);
        for (PortalSem sem : list) {
            PortalSemFile portalSemFile=new PortalSemFile();
            portalSemFile.setSemId(sem.getSemId());
            sem.setPortalSemFileList(portalSemFileService.selectPortalSemFileList(portalSemFile));
        }
        return getDataTable(list);
    }

    /**
     * 导出线索列表
     */
    @RequiresPermissions("system:sem:export")
    @Log(title = "线索", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PortalSem portalSem)
    {
        portalSem.setSemType(Long.valueOf(2));
        List<PortalSem> list = portalSemService.selectPortalSemList(portalSem);
        ExcelUtil<PortalSem> util = new ExcelUtil<PortalSem>(PortalSem.class);
        return util.exportExcel(list, "线索数据");
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
    @RequiresPermissions("system:sem:add")
    @Log(title = "线索", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PortalSem portalSem)
    {
        portalSem.setClueSource((long) -1);
        portalSem.setInputSource((long) 1);
        portalSem.setSemType(Long.valueOf(2));
        if(portalSem!=null){
            switch (portalSem.getCurrentSalary().toString()){
                case "1":
                    portalSem.setCurrentSalaryText("20w以下");
                    break;
                case "2":
                    portalSem.setCurrentSalaryText("20w~30w");
                    break;
                case "3":
                    portalSem.setCurrentSalaryText("30w~50w");
                    break;
                case "4":
                    portalSem.setCurrentSalaryText("50w~100w");
                    break;
                case "5":
                    portalSem.setCurrentSalaryText("100w以上");
                    break;
            }
        }
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
    @RequiresPermissions("system:sem:edit")
    @Log(title = "线索", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PortalSem portalSem)
    {
        if(portalSem!=null){
            switch (portalSem.getCurrentSalary().toString()){
                case "1":
                    portalSem.setCurrentSalaryText("20w以下");
                    break;
                case "2":
                    portalSem.setCurrentSalaryText("20w~30w");
                    break;
                case "3":
                    portalSem.setCurrentSalaryText("30w~50w");
                    break;
                case "4":
                    portalSem.setCurrentSalaryText("50w~100w");
                    break;
                case "5":
                    portalSem.setCurrentSalaryText("100w以上");
                    break;
            }
        }
        return toAjax(portalSemService.updatePortalSem(portalSem));
    }

    /**
     * 删除线索
     */
    @RequiresPermissions("system:sem:remove")
    @Log(title = "线索", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(portalSemService.updatePortalSemBySemIds(ids));
    }
}
