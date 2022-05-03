package com.unicorn.jpa;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.unicorn.domain.IdentifiableMarks;
import com.unicorn.domain.Unicorn;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
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
            unicorn.setHornLength(rs.getInt("hornLength"));
            unicorn.setHornColor(rs.getString("hornColor"));
            unicorn.setEyeColor(rs.getString("eyeColor"));
            unicorn.setHeight(rs.getInt("height"));
            unicorn.setHeightUnit(rs.getString("heightUnit"));
            unicorn.setWeight(rs.getInt("weight"));
            unicorn.setWeightUnit(rs.getString("weightUnit"));
            try {
                IdentifiableMarks identifiableMarks = new ObjectMapper().readValue(rs.getString("identifiableMarks"),IdentifiableMarks.class);
            } catch (IOException e) {
                throw new SQLException(e);
            }
            return unicorn;
        }
    }

    public List<Unicorn> findAll() {
        return jdbcTemplate.query("select unicornId, name, hairColor, hornLength,hornColor,eyeColor,height,heightUnit,weight,weightUnit,identifiableMarks FORMAT JSON from unicorn", new UnicornRowMapper());
    }

    public Unicorn findById(long id) {
        return jdbcTemplate.queryForObject("select unicornId, name, hairColor, hornLength,hornColor,eyeColor,height,heightUnit,weight,weightUnit,identifiableMarks FORMAT JSON from unicorn WHERE unicornId = ? ", new Object[]{id},
                new BeanPropertyRowMapper<>(Unicorn.class));
    }
    public int insert(Unicorn unicorn) throws SQLException {
        try {
            return jdbcTemplate.update("INSERT INTO Unicorn(unicornId, name, hairColor, hornLength,hornColor,eyeColor,height,heightUnit,weight,weightUnit,identifiableMarks) VALUES (?, ?, ?, ?,?,?,?,?,?,?,? FORMAT JSON)",
                    new Object[]{unicorn.getUnicornId(), unicorn.getName(), unicorn.getHairColor(), unicorn.getHornLength(), unicorn.getHornColor(), unicorn.getEyeColor(), unicorn.getHeight(), unicorn.getHeightUnit(), unicorn.getWeight(), unicorn.getWeightUnit(), new ObjectMapper().writeValueAsString(unicorn.getIdentifiableMarks())});
        } catch (JsonProcessingException e) {
            throw new SQLException(e);
        }
    }

    public int update(Unicorn unicorn) throws SQLException {
        try {
            return jdbcTemplate.update("UPDATE Unicorn set  name = ?, hairColor = ?, hornLength = ?, hornColor = ?, eyeColor = ?, height = ?, heightUnit = ?, weight = ?, weightUnit = ?, identifiableMarks = ? FORMAT JSON  WHERE unicornId = ?",
                    new Object[]{ unicorn.getName(), unicorn.getHairColor(), unicorn.getHornLength(), unicorn.getHornColor(), unicorn.getEyeColor(), unicorn.getHeight(), unicorn.getHeightUnit(), unicorn.getWeight(), unicorn.getWeightUnit(), new ObjectMapper().writeValueAsString(unicorn.getIdentifiableMarks()), unicorn.getUnicornId()});
        } catch (JsonProcessingException e) {
            throw new SQLException(e);
        }
    }
}
