package com.mastercard.citychallenge.controller;

import com.mastercard.citychallenge.service.CityConnectionService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.HttpURLConnection;

@Api(
        tags = {
                "City Distance"})
@RestController
@RequiredArgsConstructor
public class CityConnectionController {

    private final CityConnectionService cityConnectionService;

    private static final String SUCCESSFUL_OPERATION = "Successful Operation";

    private static final String INTERNAL_SERVER_ERROR = "System Error";

    private static final String YES = "Yes";

    private static final String NO = "No";

    @ApiOperation(
            value = "API to confirm whether two cities are connected, Will return true if connected, else false. Invalid date will return No ",
            nickname = "cityDistance",
            response = String.class, produces = MediaType.TEXT_PLAIN_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "origin",
                    required = false, dataType = "String", paramType = "query", value = "Origin"),
            @ApiImplicitParam(name = "destination",
                    required = false, dataType = "String", paramType = "query", value = "Destination")
    })
    @ApiResponses(
            {@ApiResponse(code = HttpURLConnection.HTTP_OK, message = SUCCESSFUL_OPERATION),
                    @ApiResponse(code = HttpURLConnection.HTTP_INTERNAL_ERROR, message = INTERNAL_SERVER_ERROR)})
    @ResponseBody
    @GetMapping(path = "/connected", produces = MediaType.TEXT_PLAIN_VALUE)
    public String validateCitiesConnection(
            @RequestParam(value = "origin", required = false) String origin, @RequestParam(value = "destination", required = false) String destination) {
        return cityConnectionService.routeExists(origin, destination) ? YES : NO;

    }
}
