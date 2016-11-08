package org.bettysinventory.beans;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.util.Base64Utils;

@Entity
@Table(name = "product_images")
public class ProductImage {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private long productId;
	private String contentType;
	@Lob
	private byte[] image;
	
	public ProductImage() {}

	public ProductImage(int productId) {
		this.productId = productId;
	}

	public ProductImage(int productId, String contentType, byte[] image) {
		this.productId = productId;
		this.contentType = contentType;
		this.image = image;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long id) {
		this.productId = id;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	
	public String getHtmlSrc() {
		return "data:" + this.contentType + ";base64," + Base64Utils.encodeToString(image);
	}
	
	@Override
	public String toString() {
		return "ProductImage [id=" + id + ", productId=" + productId + ", contentType=" + contentType + "]";
	}
	
	
	
}
