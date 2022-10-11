/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Customer;
import pojo.wareHouseUtil;

/**
 *
 * @author miqba
 */
public class DAOcustomer {
    public List<Customer> getBy(String uEmail, String uPass) {
        Transaction trans = null;
        Customer us = new Customer();
        List<Customer> user = new ArrayList();
        Session session = wareHouseUtil.getSessionFactory().openSession();
        
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Customer where email=:uEmail AND password=:uPass");
            query.setString("uEmail", uEmail);
            query.setString("uPass", uPass);
            us = (Customer) query.uniqueResult();
            user = query.list();
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
        return user;
    }
    
    public String add_customer(Customer user) {
         Transaction trans = null;
        Session session = wareHouseUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.save(user);
            trans.commit();
            return "index";
        } catch (Exception e) {
            System.out.println(e);
        }
        return "gagalRegis";
    }
    }
    

