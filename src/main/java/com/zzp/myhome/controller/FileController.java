package com.zzp.myhome.controller;

import com.zzp.myhome.service.FileService;
import com.zzp.myhome.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :  ZHANGZP
 * @Description :
 * @Creation Date:  2019/3/5
 */
@RestController
public class FileController {

    @Autowired
    private FileService fileService;

    @GetMapping("myhome/getfilelist")
    public R getlist(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize){

        return R.data(fileService.selectAll(pageNum,pageSize));
    };
}
