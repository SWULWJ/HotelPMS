package com.hotelpms.controller;

import com.hotelpms.pojo.RoomType;
import com.hotelpms.service.Impl.RoomTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

public class RoomTypeController {

    @Autowired
    private RoomTypeServiceImpl roomTypeService;

    //显示所有房间类型
    @GetMapping(value = "/queryAllRoomType")
    @ResponseBody
    public List<RoomType> queryAllRoomType(){
        return roomTypeService.queryAllRoomType();
    }

    //增加一个房间类型
    @GetMapping(value = "/addRoomType")
    @ResponseBody
    public String addRoomType(
            @RequestParam("id") String id,
            @RequestParam("name") String name,
            @RequestParam("price") String price,
            @RequestParam("bedNumber") String bedNumber,
            @RequestParam("maxPeople") String maxPeople,
            @RequestParam("minTime") String minTime
    ) {
        if(roomTypeService.addRoomType(Integer.parseInt(id),
                name, new BigDecimal(price), Integer.parseInt(bedNumber),
                Integer.parseInt(maxPeople), minTime))
            return "success";
        return "failed";
    }

    //更新一个房间类型
    @GetMapping(value = "/updateRoomType")
    @ResponseBody
    public String updateRoomType(
            @RequestParam("id") String id,
            @RequestParam("name") String name,
            @RequestParam("price") String price,
            @RequestParam("bedNumber") String bedNumber,
            @RequestParam("maxPeople") String maxPeople,
            @RequestParam("minTime") String minTime
    ){
        if(roomTypeService.updateRoomType(Integer.parseInt(id),
                name, new BigDecimal(price), Integer.parseInt(bedNumber),
                Integer.parseInt(maxPeople), minTime))
            return "success";
        return "failed";
    }

    //删除一个房间类型
    @GetMapping(value = "/deleteRoomType")
    @ResponseBody
    public String deleteRoomTypeById(
            @RequestParam("id") String id
    ){
        if(roomTypeService.deleteRoomTypeById(Integer.parseInt(id)))
            return "success";
        return "failed";
    }








//    @RequestMapping(value = "/addRoomType",method = RequestMethod.GET)
//    @ResponseBody
//    public String addRoomType(
//            @RequestParam("id") int id,
//            @RequestParam("name") String name,
//            @RequestParam("price") String price,
//            @RequestParam("bedNumber") int bedNumber,
//            @RequestParam("maxPeople") int maxPeople,
//            @RequestParam("minTime") String minTime
//    ){
//        if(roomTypeService.addRoomType(id, name, price, bedNumber, maxPeople, minTime))
//            return "success";
//        return "failed";
//    }



//    @RequestMapping(value = "/updateRoomType",method = RequestMethod.GET)
//    @ResponseBody
//    public String updateRoomType(
//            @RequestParam("id") int id,
//            @RequestParam("name") String name,
//            @RequestParam("price") BigDecimal price,
//            @RequestParam("bedNumber") int bedNumber,
//            @RequestParam("maxPeople") int maxPeople,
//            @RequestParam("minTime") String minTime
//    ){
//        if(roomTypeService.updateRoomType(id, name, price, bedNumber, maxPeople, minTime))
//            return "success";
//        return "failed";
//    }



//    @RequestMapping(value = "/deleteRoomTypeById",method = RequestMethod.GET)
//    @ResponseBody
//    public String deleteRoomTypeById(
//            @RequestParam("id") String id
//    ){
//        if(roomTypeService.deleteRoomTypeById(id))
//            return "success";
//        return "failed";
//    }



//    @RequestMapping(value = "/queryRoomTypeById",method = RequestMethod.GET)
//    @ResponseBody
//    public RoomType queryRoomTypeById(
//            @RequestParam("id") int id
//    ){
//        return roomTypeService.queryRoomTypeById(id);
//    }

//    @RequestMapping(value = "/queryRoomTypeById",method = RequestMethod.GET)
//    @ResponseBody
//    public RoomType queryRoomTypeById(
//            @RequestParam("id") String id
//    ){
//        return roomTypeService.queryRoomTypeById(Integer.parseInt(id));
//    }

//    @RequestMapping(value = "/QueryRoomTypeByPrice",method = RequestMethod.GET)
//    @ResponseBody
//    public List<RoomType> queryRoomTypeByPrice(
//            @RequestParam("min_price") BigDecimal min_price,
//            @RequestParam("max_price") BigDecimal max_price
//    ){
//        return roomTypeService.queryRoomTypeByPrice(min_price,max_price);
//    }

//    @RequestMapping(value = "/queryRoomTypeByMaxPeople",method = RequestMethod.GET)
//    @ResponseBody
//    public List<RoomType> queryRoomTypeByMaxPeople(
//            @RequestParam("maxPeople") String maxPeople
//    ){
//        return roomTypeService.queryRoomTypeByMaxPeople(
//                Integer.parseInt(maxPeople));
//    }
//
//    @RequestMapping(value = "/queryRoomTypeByMinTime",method = RequestMethod.GET)
//    @ResponseBody
//    public List<RoomType> queryRoomTypeByMinTime(
//            @RequestParam("minTime") String minTime
//    ){
//        return roomTypeService.queryRoomTypeByMinTime(minTime);
//    }

//    @RequestMapping(value = "/queryRoomTypeByBedNum",method = RequestMethod.GET)
//    @ResponseBody
//    public List<RoomType> queryRoomTypeByBedNum(
//            @RequestParam("bedNumber") int bedNumber
//    ){
//        return roomTypeService.queryRoomTypeByBedNum(bedNumber);
//    }

//    @RequestMapping(value = "/queryRoomTypeByBedNum",method = RequestMethod.GET)
//    @ResponseBody
//    public List<RoomType> queryRoomTypeByBedNum(
//            @RequestParam("bedNumber") String bedNumber
//    ){
//        return roomTypeService.queryRoomTypeByBedNum(
//                Integer.parseInt(bedNumber));
//    }


}
