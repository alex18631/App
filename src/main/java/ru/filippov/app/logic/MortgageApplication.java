package ru.filippov.app.logic;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "user_entity")
public class MortgageApplication {
    @Transient
    private UUID uuid = UUID.randomUUID();

    @Id
    private String id;
    private String firstName;
    private String secondName;
    private String lastName;
    private String passport;
    private LocalDate birthDate;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private int salary;
    private int creditAmount;
    private int durationInMonth;
    @Enumerated(EnumType.STRING)
    private MortgageApplicationStatus status;

    public MortgageApplication() {
    }

    public MortgageApplication(String firstName, String secondName, String lastName, String passport,
                               LocalDate birthDate, Gender gender, int salary,
                               int creditAmount, int durationInMonth) {
        this.id = uuid.toString();
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.passport = passport;
        this.birthDate = birthDate;
        this.gender = gender;
        this.salary = salary;
        this.creditAmount = creditAmount;
        this.durationInMonth = durationInMonth;
        this.status = MortgageApplicationStatus.PROCESSING;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
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

    public MortgageApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(MortgageApplicationStatus status) {
        this.status = status;
    }


}
