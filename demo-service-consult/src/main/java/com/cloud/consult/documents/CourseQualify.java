package com.cloud.consult.documents;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import com.cloud.consult.documents.models.Course;
import com.cloud.consult.documents.models.Qualify;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CourseQualify {

	private Course course;
	private List<Qualify> listQualify;
	
	public Double getAverageTotal() {
		DoubleSummaryStatistics res = listQualify.stream().map(q -> q.getAverage())
										.collect(Collectors.summarizingDouble(Double::doubleValue));
		
		return res.getAverage();
	}
}
