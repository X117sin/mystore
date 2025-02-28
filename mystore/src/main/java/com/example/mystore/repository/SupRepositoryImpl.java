package com.example.mystore.repository;

import com.example.mystore.entity.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SupRepositoryImpl implements SupRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Supplier findSupplier(Supplier supplier) {
        String sql = "SELECT * FROM supplier WHERE scode = ? AND spassword = ?";
        List<Supplier> suppliers = jdbcTemplate.query(sql,
                new Object[]{supplier.getScode(), supplier.getSpassword()},
                new SupplierRowMapper());
        return suppliers.isEmpty() ? null : suppliers.get(0);
    }

    private static class SupplierRowMapper implements RowMapper<Supplier> {
        @Override
        public Supplier mapRow(ResultSet rs, int rowNum) throws SQLException {
            Supplier supplier = new Supplier();
            supplier.setScode(rs.getString("scode"));
            supplier.setSpassword(rs.getString("spassword"));
            supplier.setSname(rs.getString("sname"));
            supplier.setSweixin(rs.getString("sweixin"));
            supplier.setTel(rs.getString("tel"));
            supplier.setEvaluate(rs.getFloat("evaluate"));
            return supplier;
        }
    }
}