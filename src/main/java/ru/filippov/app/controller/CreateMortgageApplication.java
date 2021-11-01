package ru.filippov.app.controller;

import ru.filippov.app.logic.Gender;
import ru.filippov.app.logic.MortgageApplication;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
import java.time.LocalDate;

public class CreateMortgageApplication {

    private String firstName;
    private String secondName;
    private String lastName;
    private String passport;
    private LocalDate birthDate;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private BigDecimal salary;
    private BigDecimal creditAmount;
    private int durationInMonths;

    public boolean poleNoEmpty() {
        return this.firstName != null &&
                this.secondName != null &&
                this.lastName != null &&
                this.passport != null &&
                this.birthDate != null &&
                this.gender != null;
    }

    public CreateMortgageApplication() {
    }

    public CreateMortgageApplication(String firstName, String secondName, String lastName,
                                     String passport, LocalDate birthDate, Gender gender,
                                     BigDecimal salary, BigDecimal creditAmount, int durationInMonth) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.passport = passport;
        this.birthDate = birthDate;
        this.gender = gender;
        this.salary = salary;
        this.creditAmount = creditAmount;
        this.durationInMonths = durationInMonth;
    }

    public MortgageApplication getCustomer(CreateMortgageApplication user) {
        return new MortgageApplication(user.getFirstName(), user.getSecondName(),
                user.getLastName(), user.getPassport(),
                user.getBirthDate(), user.getGender(),
                user.getSalary(), user.getCreditAmount(),
                user.getDurationInMonths());
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }


    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public BigDecimal getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(BigDecimal creditAmount) {
        this.creditAmount = creditAmount;
    }

    public int getDurationInMonths() {
        return durationInMonths;
    }

    public void setDurationInMonths(int durationInMonths) {
        this.durationInMonths = durationInMonths;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
