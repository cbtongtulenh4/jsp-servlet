package com.minhphuc.service.impl;

import com.minhphuc.service.HomeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HomeServiceImpl implements HomeService {

    @Override
    public List<String> loadMenu() {
        List<String> menus = new ArrayList<>();
        menus.add("Hello");
        menus.add("Lady Girls");
        menus.add("Mình là Brady");
        return menus;
    }
}
