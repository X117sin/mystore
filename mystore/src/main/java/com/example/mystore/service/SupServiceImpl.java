package com.example.mystore.service;

import com.example.mystore.core.Result;
import com.example.mystore.entity.Supplier;
import com.example.mystore.repository.SupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupServiceImpl implements SupService {

    @Autowired
    private SupRepository supRepository;

    @Override
    public Result checkSupplier(Supplier supplier) {
        if (supplier == null || supplier.getScode() == null || supplier.getSpassword() == null) {
            return new Result(false, "用户名和密码不能为空");
        }

        Supplier foundSupplier = supRepository.findSupplier(supplier);
        if (foundSupplier == null) {
            return new Result(false, "用户名或密码错误");
        }

        return new Result(true, "登录成功", foundSupplier);
    }
}