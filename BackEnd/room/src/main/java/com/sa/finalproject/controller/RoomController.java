package com.sa.finalproject.controller;

import com.sa.finalproject.model.Room;
import com.sa.finalproject.security.jwt.JwtUtils;
import com.sa.finalproject.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;

import javax.security.sasl.AuthenticationException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {

    //    @Value("${subo8.app.jwtSecret}")
//    private String jwtSecret;
    @Value("${subo8.app.jwtCookieName}")
    private String jwtCookie;

    @Autowired
    private JwtUtils jwtUtils;
    private RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public List<Room> getRooms(HttpServletRequest request) throws AuthenticationException {
        Cookie cookie = WebUtils.getCookie(request, jwtCookie);
        String jwt = cookie.getValue();

        String userRole = jwtUtils.getUserRoleFromJwtToken(jwt);
        //System.out.println("User Role "+userRole);
        if(!userRole.equals("ROLE_ADMIN") && !userRole.equals("ROLE_USER"))
            throw new AuthenticationException();
        //System.out.println("Incorrect "+userRole);
        return roomService.getRooms();


    }


    @GetMapping("/{roomId}")
    public Room getRoomById(HttpServletRequest request,@PathVariable String roomId) throws AuthenticationException {

        Cookie cookie = WebUtils.getCookie(request, jwtCookie);
        String jwt = cookie.getValue();

        String userRole = jwtUtils.getUserRoleFromJwtToken(jwt);
        //System.out.println("User Role "+userRole);
        if(!userRole.equals("ROLE_ADMIN") && !userRole.equals("ROLE_USER"))
            throw new AuthenticationException();
        return roomService.findById(roomId);


    }

    @PostMapping("/")
    public Room createRoom(HttpServletRequest request,@RequestBody Room room) throws AuthenticationException {

        Cookie cookie = WebUtils.getCookie(request, jwtCookie);
        String jwt = cookie.getValue();

        String userRole = jwtUtils.getUserRoleFromJwtToken(jwt);
        //System.out.println("User Role "+userRole);
        if(!userRole.equals("ROLE_ADMIN"))
            throw new AuthenticationException();
        return roomService.createRoom(room);
    }

    @DeleteMapping("/{roomId}")
    public void deleteRoom(HttpServletRequest request,@PathVariable String roomId) throws AuthenticationException {
        Cookie cookie = WebUtils.getCookie(request, jwtCookie);
        String jwt = cookie.getValue();

        String userRole = jwtUtils.getUserRoleFromJwtToken(jwt);
        //System.out.println("User Role "+userRole);
        if(!userRole.equals("ROLE_ADMIN"))
            throw new AuthenticationException();

        roomService.deleteRoom(roomId);
    }

    @PutMapping("/{roomId}")
    public Room updateRoom(HttpServletRequest request,@PathVariable String roomId, @RequestBody Room room) throws AuthenticationException {
        Cookie cookie = WebUtils.getCookie(request, jwtCookie);
        String jwt = cookie.getValue();

        String userRole = jwtUtils.getUserRoleFromJwtToken(jwt);
        //System.out.println("User Role "+userRole);
        if(!userRole.equals("ROLE_ADMIN") )
            throw new AuthenticationException();

        return roomService.updateRoom(roomId, room);
    }

    @GetMapping("/book/{roomId}")
    public ResponseEntity<Object> bookRoomById(HttpServletRequest request,@PathVariable String roomId) throws AuthenticationException {
        Cookie cookie = WebUtils.getCookie(request, jwtCookie);
        String jwt = cookie.getValue();

        String userRole = jwtUtils.getUserRoleFromJwtToken(jwt);
        //System.out.println("User Role "+userRole);
        if(!userRole.equals("ROLE_ADMIN") )
            throw new AuthenticationException();
        Room room = null;

        try {
            room = roomService.bookRoomAvailability(roomId);
        }catch (IllegalStateException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }catch (IllegalArgumentException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(room, HttpStatus.OK);
    }

    @PutMapping("/checkout/{roomId}")
    public ResponseEntity<Object> roomCheckout(HttpServletRequest request,@PathVariable String roomId) throws AuthenticationException {
        Cookie cookie = WebUtils.getCookie(request, jwtCookie);
        String jwt = cookie.getValue();

        String userRole = jwtUtils.getUserRoleFromJwtToken(jwt);
        //System.out.println("User Role "+userRole);
        if(!userRole.equals("ROLE_ADMIN") )
            throw new AuthenticationException();

        Room room = null;

        try {
            room = roomService.roomCheckout(roomId);
        }catch (IllegalStateException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }catch (IllegalArgumentException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(room, HttpStatus.OK);
    }

}
