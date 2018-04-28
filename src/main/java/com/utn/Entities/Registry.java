package com.utn.Entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Matias on 24/04/2018.
 */
@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Registry {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String os;
    private String browser;

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }
}