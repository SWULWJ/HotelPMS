package com.hotelpms.controller;

import com.hotelpms.pojo.TenantRoomRecords;
import com.hotelpms.service.Impl.TenantRoomRecordsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TenantRoomRecordController {

    @Autowired
    TenantRoomRecordsServiceImpl tenantRoomRecordsService;

//    @RequestMapping(value = "/addTenantRoomRecords",method = RequestMethod.GET)
//    @ResponseBody
//    public String addTenantRoomRecords(
//            @RequestParam("id") int id,
//            @RequestParam("tenant_id") int tenant_id ,
//            @RequestParam("room_id") int room_id ){
//        if(tenantRoomService.addTenantRoomRecords(id, tenant_id, room_id))
//            return "success";
//        return "failed";
//    }

    // 添加一条记录
    // 输入: id,tenant_id,room_id
    // 输出: success or failed
    @RequestMapping(value = "/addTenantRoomRecords",method = RequestMethod.GET)
    @ResponseBody
    public String addTenantRoomRecords(
            @RequestParam("id") String id,
            @RequestParam("tenant_id") String tenant_id ,
            @RequestParam("room_id") String room_id ){
        if(tenantRoomRecordsService.addTenantRoomRecords(Integer.parseInt(id),
                Integer.parseInt(tenant_id), Integer.parseInt(room_id)))
            return "success";
        return "failed";
    }

//    @RequestMapping(value = "/updateTenantRoomRecords",method = RequestMethod.GET)
//    @ResponseBody
//    public String updateTenantRoomRecords(
//            @RequestParam("id") int id,
//            @RequestParam("tenant_id") int tenant_id ,
//            @RequestParam("room_id") int room_id ){
//        if(tenantRoomService.updateTenantRoomRecords(id, tenant_id, room_id))
//            return "success";
//        return "failed";
//    }

    // 更新一条记录
    // 输入: id,tenant_id,room_id
    // 输出: success or failed
    @RequestMapping(value = "/updateTenantRoomRecords",method = RequestMethod.GET)
    @ResponseBody
    public String updateTenantRoomRecords(
            @RequestParam("id") String id,
            @RequestParam("tenant_id") String tenant_id ,
            @RequestParam("room_id") String room_id ){
        if(tenantRoomRecordsService.updateTenantRoomRecords(Integer.parseInt(id),
                Integer.parseInt(tenant_id), Integer.parseInt(room_id)))
            return "success";
        return "failed";
    }

//    @RequestMapping(value = "/deleteTenantRoomRecords",method = RequestMethod.GET)
//    @ResponseBody
//    public String deleteTenantRoomRecords(@RequestParam("id") int id){
//        if(tenantRoomService.deleteTenantRoomRecords(id))
//            return "success";
//        return "failed";
//    }

    // 删除一条记录
    // 输入: id
    // 输出: success or failed
    @RequestMapping(value = "/deleteTenantRoomRecords",method = RequestMethod.GET)
    @ResponseBody
    public String deleteTenantRoomRecords(@RequestParam("id") String id){
        if(tenantRoomRecordsService.deleteTenantRoomRecords(Integer.parseInt(id)))
            return "success";
        return "failed";
    }

//    @RequestMapping(value = "/queryTenantRoomRecordsById",method = RequestMethod.GET)
//    @ResponseBody
//    public TenantRoom queryTenantRoomRecordsById(@RequestParam("id") int id){
//        return tenantRoomService.queryTenantRoomRecordsById(id);
//    }

    // 根据 roomId 查询记录
    // 输入: roomId
    // 输出: List<TenantRoom>
    @RequestMapping(value = "/queryTenantRoomRecordsById",method = RequestMethod.GET)
    @ResponseBody
    public List<TenantRoomRecords> queryTenantRoomRecordsById(@RequestParam("roomId") String roomId){
        List<TenantRoomRecords> list = new ArrayList<>();
        list.add(tenantRoomRecordsService.queryTenantRoomRecordsById(Integer.parseInt(roomId)));
        return list;
    }

//    @RequestMapping(value = "/queryTenantRoomRecordsByTenantId",method = RequestMethod.GET)
//    @ResponseBody
//    public List<TenantRoom> queryTenantRoomRecordsByTenantId(
//            @RequestParam("tenant_id") int tenant_id){
//        return tenantRoomService.queryTenantRoomRecordsByTenantId(tenant_id);
//    }

    // 根据 tenantId 查询记录
    // 输入: tenantId
    // 输出: List<TenantRoom>
    @RequestMapping(value = "/queryTenantRoomRecordsByTenantId",method = RequestMethod.GET)
    @ResponseBody
    public List<TenantRoomRecords> queryTenantRoomRecordsByTenantId(
            @RequestParam("tenantId") String tenant_id){
        return tenantRoomRecordsService.queryTenantRoomRecordsByTenantId(Integer.parseInt(tenant_id));
    }

    // 查询所有记录
    // 输入: 无
    // 输出: List<TenantRoom>
    @RequestMapping(value = "/queryAllTenantRoomRecords",method = RequestMethod.GET)
    @ResponseBody
    public List<TenantRoomRecords> queryAllTenantRoomRecords(){
        return tenantRoomRecordsService.queryAllTenantRoomRecords();
    }

}
