package com.hotelpms.controller;

import com.hotelpms.pojo.TenantInfo;
import com.hotelpms.service.Impl.TenantInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TenantInfoController {

    @Autowired
    private TenantInfoServiceImpl tenantInfoService;

    // 查询所有旅客信息
    @GetMapping(value = "/queryAllTenantInfo")
    @ResponseBody
    public List<TenantInfo> queryAllTenantInfo() {
        return tenantInfoService.queryAllTenantInfo();
    }

    //通过身份证号查询住客信息
    @GetMapping(value = "/queryTenantInfoByIdCard")
    @ResponseBody
    public List<TenantInfo> queryTenantInfoByIdCard(
            @RequestParam("idCard") String idCard
    ){
        return tenantInfoService.queryTenantInfoByIdCard(idCard);
    }

    // 添加一条旅客信息
    @GetMapping(value = "/addTenantInfo")
    @ResponseBody
    public String addTenantInfo(
            @RequestParam("id") String id,
            @RequestParam("name") String name,
            @RequestParam("gender") String gender,
            @RequestParam("idCard") String id_card
    ) {
        if(tenantInfoService.addTenantInfo(Integer.parseInt(id),
                name, gender, id_card))
            return "success";
        return "failed";
    }

    // 更新一条旅客信息
    @GetMapping(value = "/updateTenantInfo")
    @ResponseBody
    public String updateTenantInfo(
            @RequestParam("id") String id,
            @RequestParam("name") String name,
            @RequestParam("gender") String gender,
            @RequestParam("idCard") String id_card
    ) {
        if(tenantInfoService.updateTenantInfo(Integer.parseInt(id),
                name, gender, id_card))
            return "success";
        return "failed";
    }

    // 删除一条旅客信息
    @GetMapping(value = "/deleteTenantInfo")
    @ResponseBody
    public String deleteTenantInfo(
            @RequestParam("id") String id
    ) {
        if(tenantInfoService.deleteTenantInfo(Integer.parseInt(id)))
            return "success";
        return "failed";
    }

    // 根据 id 查询一条旅客信息
    @GetMapping(value = "/queryTenantInfoById")
    @ResponseBody
    public List<TenantInfo> queryTenantInfoById(
            @RequestParam("id") String id
    ) {
        List<TenantInfo> list = new ArrayList<>();
        list.add(tenantInfoService.queryTenantInfoById(Integer.parseInt(id)));
        return list;
    }

    // 根据 name 查询一条旅客信息
    @GetMapping(value = "/queryTenantInfoByName")
    @ResponseBody
    public List<TenantInfo> queryTenantInfoByName(
        @RequestParam("name") String name
    ) {
        return tenantInfoService.queryTenantInfoByName(name);
    }
}
