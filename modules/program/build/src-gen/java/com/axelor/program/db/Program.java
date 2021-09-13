package com.axelor.program.db;

import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

import com.axelor.auth.db.AuditableModel;
import com.axelor.db.annotations.Widget;
import com.google.common.base.MoreObjects;

@Entity
@Cacheable
@Table(name = "PROGRAM_PROGRAM", indexes = { @Index(columnList = "name") })
public class Program extends AuditableModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROGRAM_PROGRAM_SEQ")
	@SequenceGenerator(name = "PROGRAM_PROGRAM_SEQ", sequenceName = "PROGRAM_PROGRAM_SEQ", allocationSize = 1)
	private Long id;

	@NotNull
	private String status;

	@NotNull
	private String title;

	private Integer program_number = 0;

	private String address;

	private Integer zip_code = 0;

	private String city;

	private String name;

	private String internal_interlocutor;

	private String interlocutor_1;

	private String interlocutor_2;

	@Widget(title = "Attributes")
	@Basic(fetch = FetchType.LAZY)
	@Type(type = "json")
	private String attrs;

	public Program() {
	}

	public Program(Integer zip_code, String name) {
		this.zip_code = zip_code;
		this.name = name;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getProgram_number() {
		return program_number == null ? 0 : program_number;
	}

	public void setProgram_number(Integer program_number) {
		this.program_number = program_number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getZip_code() {
		return zip_code == null ? 0 : zip_code;
	}

	public void setZip_code(Integer zip_code) {
		this.zip_code = zip_code;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInternal_interlocutor() {
		return internal_interlocutor;
	}

	public void setInternal_interlocutor(String internal_interlocutor) {
		this.internal_interlocutor = internal_interlocutor;
	}

	public String getInterlocutor_1() {
		return interlocutor_1;
	}

	public void setInterlocutor_1(String interlocutor_1) {
		this.interlocutor_1 = interlocutor_1;
	}

	public String getInterlocutor_2() {
		return interlocutor_2;
	}

	public void setInterlocutor_2(String interlocutor_2) {
		this.interlocutor_2 = interlocutor_2;
	}

	public String getAttrs() {
		return attrs;
	}

	public void setAttrs(String attrs) {
		this.attrs = attrs;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (this == obj) return true;
		if (!(obj instanceof Program)) return false;

		final Program other = (Program) obj;
		if (this.getId() != null || other.getId() != null) {
			return Objects.equals(this.getId(), other.getId());
		}

		return false;
	}

	@Override
	public int hashCode() {
		return 31;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
			.add("id", getId())
			.add("status", getStatus())
			.add("title", getTitle())
			.add("program_number", getProgram_number())
			.add("address", getAddress())
			.add("zip_code", getZip_code())
			.add("city", getCity())
			.add("name", getName())
			.add("internal_interlocutor", getInternal_interlocutor())
			.add("interlocutor_1", getInterlocutor_1())
			.add("interlocutor_2", getInterlocutor_2())
			.omitNullValues()
			.toString();
	}
}
