package com.egms.api.service;

import com.egms.api.model.Coordinate;
import com.egms.api.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IReportsRepository extends JpaRepository<Report, Integer> {

    @Query("SELECT c1 FROM Coordinate c1\n" +
            "JOIN Coordinate c2\n" +
            "ON c1.area_id = c2.area_id\n" +
            "WHERE (c1.coord_no = 1 AND (?1>c1.lng AND ?2<c1.lat))" +
            " AND (c2.coord_no = 3 AND (?1<c2.lng AND ?2>c2.lat))")
    Coordinate getAreaId(double longitude1, double latitude1);

}
