package com.trg.Dao;

import com.trg.entity.Employee;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class EmployeeDao {
    
    
    static Map<Integer, Employee> data = new TreeMap<>();

    public EmployeeDao() {
        data.put(100,new Employee(100,"aswin",28347897));
        data.put(101,new Employee(101,"raja",90293897));
        data.put(102,new Employee(102,"ramesh",98327897));
    }
    
    public Employee getEmployee(int id){
        return data.get(id);
    }
    
    public boolean saveEmployee(Employee e){
        if(data.containsKey(e.getEmpId()))
            return false;
        data.put(e.getEmpId(),e);
        return true;
    }
    
    public Collection<Employee> getAll(){
        return data.values();
    }
    
    public boolean updateEmployee(Employee e){
        if(data.containsKey(e.getEmpId())){
            data.put(e.getEmpId(),e);
            return true;
        }
        return false;
    }
    
    public boolean deleteEmployee(int id){
        if(data.containsKey(id)){
            data.remove(id);
            return true;
        }
        return false;
    }

    public Employee updateEmployee(int eid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
