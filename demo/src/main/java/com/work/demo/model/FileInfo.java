package com.work.demo.model;

import java.io.Serializable;

public class FileInfo implements Serializable {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column FILE_INFO.UUID
	 * @mbg.generated  Tue Oct 23 16:48:47 CST 2018
	 */
	private String uuid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column FILE_INFO.FILENAME
	 * @mbg.generated  Tue Oct 23 16:48:47 CST 2018
	 */
	private String filename;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column FILE_INFO.FILEPATH
	 * @mbg.generated  Tue Oct 23 16:48:47 CST 2018
	 */
	private String filepath;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table FILE_INFO
	 * @mbg.generated  Tue Oct 23 16:48:47 CST 2018
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column FILE_INFO.UUID
	 * @return  the value of FILE_INFO.UUID
	 * @mbg.generated  Tue Oct 23 16:48:47 CST 2018
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column FILE_INFO.UUID
	 * @param uuid  the value for FILE_INFO.UUID
	 * @mbg.generated  Tue Oct 23 16:48:47 CST 2018
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid == null ? null : uuid.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column FILE_INFO.FILENAME
	 * @return  the value of FILE_INFO.FILENAME
	 * @mbg.generated  Tue Oct 23 16:48:47 CST 2018
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column FILE_INFO.FILENAME
	 * @param filename  the value for FILE_INFO.FILENAME
	 * @mbg.generated  Tue Oct 23 16:48:47 CST 2018
	 */
	public void setFilename(String filename) {
		this.filename = filename == null ? null : filename.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column FILE_INFO.FILEPATH
	 * @return  the value of FILE_INFO.FILEPATH
	 * @mbg.generated  Tue Oct 23 16:48:47 CST 2018
	 */
	public String getFilepath() {
		return filepath;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column FILE_INFO.FILEPATH
	 * @param filepath  the value for FILE_INFO.FILEPATH
	 * @mbg.generated  Tue Oct 23 16:48:47 CST 2018
	 */
	public void setFilepath(String filepath) {
		this.filepath = filepath == null ? null : filepath.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table FILE_INFO
	 * @mbg.generated  Tue Oct 23 16:48:47 CST 2018
	 */
	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (that == null) {
			return false;
		}
		if (getClass() != that.getClass()) {
			return false;
		}
		FileInfo other = (FileInfo) that;
		return (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
				&& (this.getFilename() == null ? other.getFilename() == null
						: this.getFilename().equals(other.getFilename()))
				&& (this.getFilepath() == null ? other.getFilepath() == null
						: this.getFilepath().equals(other.getFilepath()));
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table FILE_INFO
	 * @mbg.generated  Tue Oct 23 16:48:47 CST 2018
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
		result = prime * result + ((getFilename() == null) ? 0 : getFilename().hashCode());
		result = prime * result + ((getFilepath() == null) ? 0 : getFilepath().hashCode());
		return result;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table FILE_INFO
	 * @mbg.generated  Tue Oct 23 16:48:47 CST 2018
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", uuid=").append(uuid);
		sb.append(", filename=").append(filename);
		sb.append(", filepath=").append(filepath);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}