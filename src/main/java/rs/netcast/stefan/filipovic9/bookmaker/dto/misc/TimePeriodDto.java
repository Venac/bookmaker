package rs.netcast.stefan.filipovic9.bookmaker.dto.misc;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class TimePeriodDto {
	@NotNull
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
	private Date start;
	@NotNull
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
	private Date end;
}
