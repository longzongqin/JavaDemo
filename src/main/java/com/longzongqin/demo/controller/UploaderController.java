package com.longzongqin.demo.controller;


import ch.qos.logback.core.util.FileUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.longzongqin.demo.entity.ImgInfo;
import com.longzongqin.demo.service.ImgInfoService;
import com.longzongqin.demo.utils.JacksonUtil;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Arrays;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author longzongqin
 * @since 2018-03-19
 */
@Controller
@RequestMapping("/uploader")
public class UploaderController {

    @Autowired
    private ImgInfoService imgInfoService;

    @GetMapping
    public String index(ModelMap map){
//        EntityWrapper<ImgInfo> ew = new EntityWrapper<ImgInfo>();
//        ew.eq("status",0);
//        ew.orderDesc(Arrays.asList("id"));
//        Page<ImgInfo> imgInfo = imgInfoService.selectPage(new Page<ImgInfo>(0,20),ew);
//        map.put("imgInfo", imgInfo);
        return "uploader/index";
    }

//    @PostMapping("upload")
//    @ResponseBody
//    public Boolean upload(MultipartFile file) {
//        File savefile = new File("/gdpHugeFileDIr",file.getOriginalFilename());
//        try {
//            file.transferTo(savefile);//将文件保存E盘下
//        } catch (IOException e) {
//            return false;
//        }
//        return true;
//    }


    /**
     * @author van
     * 检查文件存在与否
     */
    @PostMapping("checkFile")
    @ResponseBody
    public Boolean checkFile(@RequestParam(value = "md5File") String md5File) {
        Boolean exist = false;

        //实际项目中，这个md5File唯一值，应该保存到数据库或者缓存中，通过判断唯一值存不存在，来判断文件存不存在，这里我就不演示了
		/*if(true) {
			exist = true;
		}*/
        return exist;
    }

    /**
     * @author van
     * 检查分片存在与否
     */
    @PostMapping("checkChunk")
    @ResponseBody
    public Boolean checkChunk(@RequestParam(value = "md5File") String md5File,
                              @RequestParam(value = "chunk") Integer chunk) {
        Boolean exist = false;
        String path = "/gdpHugeFileDIr/"+md5File+"/";//分片存放目录
        String chunkName = chunk+ ".tmp";//分片名
        File file = new File(path+chunkName);
        if (file.exists()) {
            exist = true;
        }
        return exist;
    }

    /**
     * @author van
     * 上传，这里根据文件md5值生成目录，并将分片文件放到该目录下
     */
    @PostMapping("upload")
    @ResponseBody
    public Boolean upload(@RequestParam(value = "file") MultipartFile file,
                          @RequestParam(value = "md5File") String md5File,
                          @RequestParam(value = "chunk",required= false) Integer chunk) { //第几片，从0开始
        String path = "/gdpHugeFileDIr/"+md5File+"/";
        File dirfile = new File(path);
        if (!dirfile.exists()) {//目录不存在，创建目录
            dirfile.mkdirs();
        }
        String chunkName;
        if(chunk == null) {//表示是小文件，还没有一片
            chunkName = "0.tmp";
        }else {
            chunkName = chunk+ ".tmp";
        }
        String filePath = path+chunkName;
        File savefile = new File(filePath);

        try {
            if (!savefile.exists()) {
                savefile.createNewFile();//文件不存在，则创建
            }
            file.transferTo(savefile);//将文件保存
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    /**
     * @author van
     * 合成分片
     */
    @PostMapping("merge")
    @ResponseBody
    @Async
    public Boolean  merge(@RequestParam(value = "chunks",required =false) Integer chunks,
                          @RequestParam(value = "md5File") String md5File,
                          @RequestParam(value = "name") String name) throws Exception {
        String path = "/gdpHugeFileDIr";
        FileOutputStream fileOutputStream = new FileOutputStream(path+"/"+name);  //合成后的文件
        try {
            byte[] buf = new byte[1024];
            for(long i=0;i<chunks;i++) {
                String chunkFile=i+".tmp";
                File file = new File(path+"/"+md5File+"/"+chunkFile);
                InputStream inputStream = new FileInputStream(file);
                int len = 0;
                while((len=inputStream.read(buf))!=-1){
                    fileOutputStream.write(buf,0,len);
                }
                inputStream.close();
            }
            //合并完，要删除md5目录及临时文件，节省空间。这里代码省略
            //删除比较耗时，可能会导致响应超时，需要异步删除
            FileUtils.deleteDirectory(new File(path + "/" + md5File));

        } catch (Exception e) {
            return false;
        }finally {
            fileOutputStream.close();
        }
        return true;
    }



}

