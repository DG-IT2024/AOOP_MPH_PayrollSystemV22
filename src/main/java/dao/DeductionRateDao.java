/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author danilo
 */
import java.util.List;
import model.DeductionRate;

public interface DeductionRateDao {
    DeductionRate getById(int id) throws Exception;
    List<DeductionRate> getAll() throws Exception;
    List<DeductionRate> getByType(String type) throws Exception;
    DeductionRate findMatchingRate(String type, double income) throws Exception; // For lookup (SSS, PhilHealth, etc.)
   
}
