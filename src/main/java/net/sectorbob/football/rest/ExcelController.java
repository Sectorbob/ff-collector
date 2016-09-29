package net.sectorbob.football.rest;

import net.sectorbob.football.excel.ProjectionSheetGenerator;
import net.sectorbob.football.exception.InternalServerErrorException;
import net.sectorbob.football.model.MasterPlayerRecord;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by ltm688 on 9/29/16.
 */
@RestController
@RequestMapping(value="/players/current/players.xls")
public class ExcelController {

    @Autowired
    CurrentPlayerJoinController currentPlayerJoinController;

    @Autowired
    ProjectionSheetGenerator projectionSheetGenerator;

    @RequestMapping
    public ResponseEntity<InputStreamResource> getExcelReport() {
        List<MasterPlayerRecord> players = currentPlayerJoinController.getMasterPlayers();

        Workbook wb = projectionSheetGenerator.generate(players);

        // A ByteArrayOutputStream holds the content in memory
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try {
            wb.write(outputStream);
        } catch (IOException e) {
            throw new InternalServerErrorException("Error with output stream", e);
        }

        // To convert it to a byte[] - simply use
        final byte[] bytes = outputStream.toByteArray();

        // To convert bytes to an InputStream, use a ByteArrayInputStream
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);

        return ResponseEntity
                .ok()
                .contentLength(bytes.length)
                .contentType(
                        MediaType.parseMediaType("application/octet-stream"))
                .body(new InputStreamResource(inputStream));
    }
}
