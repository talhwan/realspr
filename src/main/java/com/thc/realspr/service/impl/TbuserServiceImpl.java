package com.thc.realspr.service.impl;

import com.thc.realspr.domain.Tbuser;
import com.thc.realspr.dto.TbuserDto;
import com.thc.realspr.mapper.TbuserMapper;
import com.thc.realspr.repository.TbuserRepository;
import com.thc.realspr.service.TbuserService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TbuserServiceImpl implements TbuserService {

    private final TbuserRepository tbuserRepository;
    private final TbuserMapper tbuserMapper;
    public TbuserServiceImpl(
            TbuserRepository tbuserRepository
            ,TbuserMapper tbuserMapper
    ) {
        this.tbuserRepository = tbuserRepository;
        this.tbuserMapper = tbuserMapper;
    }
    /*
    public Map<String, Object> create(Map<String, Object> param){
        Map<String, Object> returnMap = new HashMap<String, Object>();
        System.out.println(param);
        Tbuser tbuser = Tbuser.of(param.get("username") + "", param.get("password") + "");
        tbuserRepository.save(tbuser);
        returnMap.put("id", tbuser.getId());
        return returnMap;
    }
    public Map<String, Object> update(Map<String, Object> param){
        Map<String, Object> returnMap = new HashMap<String, Object>();
        System.out.println(param);
        Tbuser tbuser = tbuserRepository.findById(param.get("id") + "").orElseThrow(() -> new RuntimeException(""));
        if(param.get("name") != null) {
            tbuser.setName(param.get("name") + "");
        }
        if(param.get("nick") != null) {
            tbuser.setNick(param.get("nick") + "");
        }
        if(param.get("phone") != null) {
            tbuser.setPhone(param.get("phone") + "");
        }

        tbuserRepository.save(tbuser);
        returnMap.put("id", tbuser.getId());
        return returnMap;
    }
    */
    public TbuserDto.TbuserAfterCreateDto create(TbuserDto.TbuserCreateDto param){
        return tbuserRepository.save(param.toEntity()).toTbuserAfterCreateDto();
    }
    public TbuserDto.TbuserAfterCreateDto update(TbuserDto.TbuserUpdateDto param){
        System.out.println(param);
        Tbuser tbuser = tbuserRepository.findById(param.getId()).orElseThrow(() -> new RuntimeException(""));
        if(param.getName() != null) {
            tbuser.setName(param.getName());
        }
        if(param.getNick() != null) {
            tbuser.setNick(param.getNick());
        }
        if(param.getPhone() != null) {
            tbuser.setPhone(param.getPhone());
        }
        return tbuserRepository.save(tbuser).toTbuserAfterCreateDto();
    }
    /*
    public Map<String, Object> get(String id){
        Map<String, Object> returnMap = new HashMap<String, Object>();
        System.out.println(id);
        Tbuser tbuser = tbuserRepository.findById(id).orElseThrow(() -> new RuntimeException(""));

        returnMap.put("id", tbuser.getId());
        returnMap.put("username", tbuser.getUsername());
        returnMap.put("name", tbuser.getName());
        returnMap.put("nick", tbuser.getNick());
        returnMap.put("phone", tbuser.getPhone());

        return returnMap;
    }
    */
    public TbuserDto.TbuserSelectDto get(String id){
        //System.out.println(id);
        TbuserDto.TbuserSelectDto tbuserSelectDto = tbuserMapper.detail(id);
        //
        return tbuserSelectDto;
    }
}
