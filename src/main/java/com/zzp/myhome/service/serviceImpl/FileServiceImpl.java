package com.zzp.myhome.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zzp.myhome.dao.FileDao;
import com.zzp.myhome.entity.FileEntity;
import com.zzp.myhome.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author :  ZHANGZP
 * @Description :
 * @Creation Date:  2019/3/5
 */
@Service("FileService")
public class FileServiceImpl implements FileService {

    @Autowired
    private FileDao fileDao;

    @Override
    public void insert(FileEntity fileEntity) {
        fileDao.insert(fileEntity.getFileName(),fileEntity.getFilePath());
    }

    @Override
    public PageInfo<FileEntity> selectAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<FileEntity> fileEntityList = fileDao.selectAll();
        PageInfo result = new PageInfo(fileEntityList);
        return result;
    }
}
