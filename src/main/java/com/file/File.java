package com.file;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class File {

	@Id
	private String id;
	private String name; // 文件名称
	private String contentType; // 文件类型
	private Long size;
	private Date uploadDate;
	private String md5;
	private byte[] content;
	private String path;

	protected File() {
	}

	public File(String name, String contentType, long size, byte[] content) {
		this.name = name;
		this.contentType = contentType;
		this.size = size;
		this.uploadDate = new Date();
		this.content = content;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (object == null || getClass() != object.getClass()) {
			return false;
		}
		File fileInfo = (File) object;
		return java.util.Objects.equals(size, fileInfo.size) && java.util.Objects.equals(name, fileInfo.name)
				&& java.util.Objects.equals(contentType, fileInfo.contentType)
				&& java.util.Objects.equals(uploadDate, fileInfo.uploadDate)
				&& java.util.Objects.equals(md5, fileInfo.md5) && java.util.Objects.equals(id, fileInfo.id);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(name, contentType, size, uploadDate, md5, id);
	}

	@Override
	public String toString() {
		return "File{" + "name='" + name + '\'' + ", contentType='" + contentType + '\'' + ", size=" + size
				+ ", uploadDate=" + uploadDate + ", md5='" + md5 + '\'' + ", id='" + id + '\'' + '}';
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public Date getUpdateDate() {
		return uploadDate;
	}

	public void setUpdateDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
