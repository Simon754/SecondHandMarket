package com.market.implement;

import com.market.dao.CommentMapper;
import com.market.dao.ItemMapper;
import com.market.dao.RecordMapper;
import com.market.dao.UserMapper;
import com.market.model.*;
import com.market.service.ChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Simon
 */
@Service(value = "infoService")
public class ChangeServiceImpl implements ChangeService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private RecordMapper recordMapper;
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public boolean addItem(Item item) {
        generateImage(item.getItempic(),item.getItemname());
        item.setItempic(item.getItemname()+".jpg");
        return itemMapper.insertSelective(item) != 0;
    }

    @Override
    public boolean updateUser(User user) {
        return userMapper.updateByPrimaryKeySelective(user)!=0;
    }

    @Override
    public boolean buy(Param param) {
        itemMapper.updateByPrimaryKeySelective(param.item);
        Date date=new Date();
        SimpleDateFormat temp1=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String date1=temp1.format(date);
        try {
            Date date2=temp1.parse(date1);
            param.record.setTime(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return recordMapper.insertSelective(param.record)!=0;
    }

    @Override
    public List<Record> getRecord(User user) {
        return recordMapper.selectByUser(user);
    }

    @Override
    public boolean makeComment(Comment comment) {
        return commentMapper.insertSelective(comment)!=0;
    }

    private static void generateImage(String imgStr, String photoName)
    {
        //对字节数组字符串进行Base64解码并生成图片
        //图像数据为空
        if (imgStr == null) {
            return;
        }
        BASE64Decoder decoder = new BASE64Decoder();
        try
        {
            //Base64解码
            byte[] b = decoder.decodeBuffer(imgStr);
            for(int i=0;i<b.length;++i)
            {
                if(b[i]<0)
                {
                    //调整异常数据
                    b[i]+=256;
                }
            }
            //生成jpeg图片
            String imagePath= "C:\\Users\\Simon\\Desktop\\SHMarket\\src\\main\\resources\\static\\image\\";
            //C:\Users\Simon\Desktop\SHMarket\src\main\resources\static\image\xxx.jpg
            //新生成的图片
            String imgFilePath = imagePath+photoName+".jpg";
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            out.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
