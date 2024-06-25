package com.example.ecommerce_adidas_tuvungoc.Util;

import com.example.ecommerce_adidas_tuvungoc.Entity.Base.BaseEntity;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Calendar;

public class TimeAuto {
    @PrePersist
    public void onCreate(BaseEntity entity) {
        entity.setCreateAt(getCurrentTime());
        entity.setModifyAt(getCurrentTime());
        entity.setCreateBy(getNameStaff());
    }

    @PreUpdate
    public void onUpdate(BaseEntity entity) {
        entity.setModifyAt(getCurrentTime());
        entity.setModifyBy(getNameStaff());
    }

    public Long getCurrentTime() {
        return Calendar.getInstance().getTimeInMillis();
    }

    public String getNameStaff() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            return authentication.getName();
        } else return "Systerm filled data";
    }
}
