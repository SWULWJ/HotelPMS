package com.hotelpms.controller;

import com.hotelpms.pojo.TenantInfo;
import com.hotelpms.service.TenantInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public class TenantInfoController {

    @Autowired
    private TenantInfoServiceImpl tenantInfoService;

    @RequestMapping(value = "/AddTenantInfo",method = RequestMethod.GET)
    @ResponseBody
    public String addTenantInfo(
            @RequestParam("id") int id,
            @RequestParam("name") String name,
            @RequestParam("gender") String gender,
            @RequestParam("id_card") String id_card
    ){
        if(tenantInfoService.addTenantInfo(id, name, gender, id_card))
            return "Success";
        return "Failed";
    }

    @RequestMapping(value = "/UpdateTenantInfo",method = RequestMethod.GET)
    @ResponseBody
    public String updateTenantInfo(
            @RequestParam("id") int id,
            @RequestParam("name") String name,
            @RequestParam("gender") String gender,
            @RequestParam("id_card") String id_card
    ){
        if(tenantInfoService.updateTenantInfo(id, name, gender, id_card))
            return "Success";
        return "Failed";
    }

    @RequestMapping(value = "/DeleteTenantInfo",method = RequestMethod.GET)
    @ResponseBody
    public String deleteTenantInfo(
            @RequestParam("id") int id
    ){
        if(tenantInfoService.deleteTenantInfo(id))
            return "Success";
        return "Failed";
    }

    @RequestMapping(value = "/QueryTenantInfoById",method = RequestMethod.GET)
    @ResponseBody
    public TenantInfo queryTenantInfoById(
            @RequestParam("id") int id
    ){
        return tenantInfoService.queryTenantInfoById(id);
    }

    @RequestMapping(value = "/QueryAllTenantInfo",method = RequestMethod.GET)
    @ResponseBody
    public List<TenantInfo> queryAllTenantInfo(
            @RequestParam("id") int id
    ){
        return tenantInfoService.queryAllTenantInfo();
    }
}
