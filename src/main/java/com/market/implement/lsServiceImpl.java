package com.market.implement;

import com.market.dao.ItemMapper;
import com.market.dao.RecordMapper;
import com.market.dao.UserMapper;
import com.market.model.Item;
import com.market.model.Record;
import com.market.model.User;
import com.market.model.UserResult;
import com.market.service.LogAndSignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Simon
 */
@Service(value = "userService")
public class lsServiceImpl implements LogAndSignService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private RecordMapper recordMapper;

    @Override
    public UserResult login(User user){
        User user1=userMapper.selectByUserName(user.getUsername());
        UserResult result = new UserResult();
        List<Item> list=itemMapper.selectAll();
        if(user1!=null&&user1.getUserpwd().equals(user.getUserpwd())){
            result.setCode(1);
            result.setMessage("登陆成功");
            result.setObject(user1);
            for (Item item:list
            ) {
                String temp=get_pic_base64(item.getItempic());
                item.setItempic(temp);
            }
            result.setList(list);
            List<Record> records=recordMapper.selectByUser(user1);
            result.setRecords(records);
        }else {
            result.setCode(0);
            result.setMessage("登录失败");
        }
        return result;
    }
    @Override
    public UserResult signUp(User user){
        UserResult result=new UserResult();
        User user1;
        if(userMapper.insertSelective(user)==0){
            result.setCode(0);
            result.setMessage("注册失败");
        }else {
            user1=userMapper.selectByUserName(user.getUsername());
            result.setCode(1);
            List<Item> list=itemMapper.selectAll();
            for (Item item:list
                 ) {
                String temp=get_pic_base64(item.getItempic());
                item.setItempic(temp);
            }
            result.setMessage("注册成功");
            result.setList(list);
            result.setObject(user1);
        }

        return result;
    }
    public String get_pic_base64(String url) {
        InputStream in;
        byte[] data = null;
        // 读取图片字节数组
        try {
            //获取图片路径
            Resource resource = new ClassPathResource("/static/image/"+url);
            File file = resource.getFile();
            in = new FileInputStream(file.getPath());
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        // 返回Base64编码过的字节数组字符串
        return encoder.encode(data);
    }
}