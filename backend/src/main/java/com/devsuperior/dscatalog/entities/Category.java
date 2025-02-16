package com.devsuperior.dscatalog.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_category")
public class Category implements Serializable{
	//serializable, serve para objeto trafegar na rede
	//gravar em arquivos, ser transformado em bytes
	
	private static final long serialVersioUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	public Category() {
	
	}
	
	public Category(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	
	public Category(String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//metodo de comparacao não 100%, mais rápido
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	//metodo de comparacao mais lento, só que 100%
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		return Objects.equals(id, other.id);
	}
	
}