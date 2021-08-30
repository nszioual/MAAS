package eu.arrowhead.api.commons.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DateSerializer extends JsonSerializer<Long> {

    @Override
    public void serialize(Long date, JsonGenerator jgen, SerializerProvider serializerProvider) throws IOException {
        DateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String formattedDate = sdf.format(date);
        jgen.writeString(formattedDate);
    }
}