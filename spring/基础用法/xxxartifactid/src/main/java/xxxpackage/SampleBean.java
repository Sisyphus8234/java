package xxxpackage;

import java.util.*;

public class SampleBean {
	public String name;
	List<String> skills;
	Set<String> cities;
	int[] numbers;

	// 值来自jdbc.properties文件
	Properties conf3;

	public void setName(String name) {
		this.name = name;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	public void setCities(Set<String> cities) {
		this.cities = cities;
	}

	public void setNumbers(int[] numbers) {
		this.numbers = numbers;
	}

	public void setConf3(Properties conf3) {
		this.conf3 = conf3;
	}

}