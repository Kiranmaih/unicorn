package com.unicorn.jpa;

import com.unicorn.domain.Unicorn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UnicornRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;


    class UnicornRowMapper implements RowMapper<Unicorn> {
        @Override
        public Unicorn mapRow(ResultSet rs, int rowNum) throws SQLException {
            Unicorn unicorn = new Unicorn();
            unicorn.setUnicornId(rs.getInt("unicornId"));
            unicorn.setName(rs.getString("name"));
            unicorn.setHairColor(rs.getString("hairColor"));
            return unicorn;
        }
    }

    public List<Unicorn> findAll() {
        return jdbcTemplate.query("select * from unicorn", new UnicornRowMapper());
    }

    public Unicorn findById(long id) {
        return jdbcTemplate.queryForObject("select * from unicorn WHERE unicornId = ? ", new Object[]{id},
                new BeanPropertyRowMapper<>(Unicorn.class));
    }
    public int insert(Unicorn unicorn) throws SQLException {
        return jdbcTemplate.update("INSERT INTO Unicorn(unicornId, name, hairColor, hornLength,hornColor,eyeColor,height,heightUnit,weight,weightUnit) VALUES (?, ?, ?, ?,?,?,?,?,?,?)",
                new Object[]{unicorn.getUnicornId(), unicorn.getName(), unicorn.getHairColor(), unicorn.getHornLength(), unicorn.getHornColor(), unicorn.getEyeColor(), unicorn.getHeight(), unicorn.getHeightUnit(), unicorn.getWeight(), unicorn.getWeightUnit()});
    }
}
