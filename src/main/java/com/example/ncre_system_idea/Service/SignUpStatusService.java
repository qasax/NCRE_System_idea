package com.example.ncre_system_idea.Service;

import com.example.ncre_system_idea.DAO.AutoAssignStatusDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignUpStatusService {
    @Autowired
    AutoAssignStatusDAO autoAssignStatusDAO;

}
