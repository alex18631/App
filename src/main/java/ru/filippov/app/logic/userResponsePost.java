package ru.filippov.app.logic;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

public class userResponsePost {

    private String firstName;
    private String secondName;
    private String lastName;
    private String passport;
    private LocalDate birthDate;
    @Enumerated(EnumType.STRING)
    private userEntity.Gender gender;
    private int salary;
    private int creditAmount;
    private int durationInMonth;

    public userResponsePost() {
    }

    public userResponsePost(String firstName, String secondName, String lastName,
                            String passport, LocalDate birthDate, userEntity.Gender gender,
                            int salary, int creditAmount, int durationInMonth) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.passport = passport;
        this.birthDate = birthDate;
        this.gender = gender;
        this.salary = salary;
        this.creditAmount = creditAmount;
        this.durationInMonth = durationInMonth;
    }

    public userEntity getCustomer(userResponsePost user) {
        return new userEntity(user.getFirstName(),user.getSecondName(),
                user.getLastName(),user.getPassport(),
                user.getBirthDate(),user.getGender(),
                user.getSalary(),user.getCreditAmount(),
                user.getDurationInMonth());
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



    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(int creditAmount) {
        this.creditAmount = creditAmount;
    }

    public int getDurationInMonth() {
        return durationInMonth;
    }

    public void setDurationInMonth(int durationInMonth) {
        this.durationInMonth = durationInMonth;
    }

    public userEntity.Gender getGender() {
        return gender;
    }

    public void setGender(userEntity.Gender gender) {
        this.gender = gender;
    }
}
