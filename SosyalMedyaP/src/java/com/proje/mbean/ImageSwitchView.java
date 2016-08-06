package com.proje.mbean;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
 
@ManagedBean
public class ImageSwitchView {
     
    private List<String> images;
 
    @PostConstruct
    public void init() {
        images = new ArrayList<String>();
         
        images.add("b.jpg");
        images.add("d.jpg");
        images.add("e.jpg");
        images.add("g.jpg");
    }
 
    public List<String> getImages() {
        return images;
    }
}