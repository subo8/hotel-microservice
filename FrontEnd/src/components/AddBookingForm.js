import React from "react";
import "../App.css";
import { Row, Col, Form, Button, Alert, Badge } from "react-bootstrap";
import axios from "axios";
import BACK_END_URL from "../services/api";

class AddBookingForm extends React.Component {
  state = {
    dateOfArrival: "",
    dateOfDeparture: "",
    numberOfRooms: "",
    totalPrice: "",
    numberOfGuests: "",
    roomId: "",
    amount: "",
    creditCardId: "",
  };

  changeHandler = (event) => {
    this.setState({ [event.target.name]: event.target.value });
  };

  submitHandler = (event) => {
    event.preventDefault();
    const rooms = this.props.rooms;
    if (rooms != null && rooms.length < 1) return;

    const totalPrice = rooms.reduce(
      (total, room) => total + (room.price || 0),
      0
    );

    const bookingDetails = {
      ...this.state,
      totalPrice,
      rooms,
    };

    console.log(bookingDetails);
    axios
      .post("localhost:8999/", bookingDetails, {
        headers: {
          Authorization:
            "Bearer " + localStorage.getItem("variableName").replace(/"/g, ""),
        },
      })
      .then((res) => {
        console.log(res);
        window.location = "/bookings";
      })
      .catch((err) => console.log(err));
  };

  roomList = (rooms) =>
    rooms.map((room) => {
      return (
        <Badge
          pill
          bg="secondary"
          className="m-2"
          key={room.roomNumber}
        >{`Room #${room.roomNumber} selected`}</Badge>
      );
    });

  render() {
    const { rooms } = this.props;

    return (
      <Form id="booking-form" onSubmit={this.submitHandler}>
        <h3 style={{ textAlign: "center" }}>Make Your Reservation</h3>
        <Row className="mb-2">
          <Form.Group as={Col} className="mb-2" controlId="formBasicEmail">
            <Form.Label>Date of Arrival</Form.Label>
            <Form.Control
              type="date"
              name="dateOfArrival"
              onChange={this.changeHandler}
            />
          </Form.Group>
          <Form.Group as={Col} controlId="formBasicEmail">
            <Form.Label>Date Of Departure</Form.Label>
            <Form.Control
              type="date"
              name="dateOfDeparture"
              onChange={this.changeHandler}
            />
          </Form.Group>
        </Row>
        <Form.Group className="mb-2" controlId="formBasicEmail">
          <Form.Label>Number of Guests</Form.Label>
          <Form.Control
            type="text"
            placeholder="Enter Number of Guests"
            name="numberOfGuests"
            onChange={this.changeHandler}
          />
        </Form.Group>
        <Form.Group className="mb-2" controlId="formBasicEmail">
          <Form.Label>Number of Rooms</Form.Label>
          <Form.Control
            type="text"
            placeholder="Enter Number of Rooms"
            name="numberOfRooms"
            onChange={this.changeHandler}
          />
        </Form.Group>

        <Form.Group className="mb-3" controlId="formBasicPassword">
          <Form.Label>Other Reservations</Form.Label>
          <Form.Control
            type="text"
            placeholder="Other Reservations other than Rooms"
            name="otherReservations"
            onChange={this.changeHandler}
          />
        </Form.Group>
        <div>
          {rooms.length > 0 ? (
            this.roomList(rooms)
          ) : (
            <div className="m-2">
              <Alert variant="danger"> No Rooms Selected </Alert>
            </div>
          )}
        </div>
        <Button
          variant="primary"
          id="button"
          type="submit"
          disabled={rooms.length < 1 ? "disabled" : ""}
        >
          Submit
        </Button>
      </Form>
    );
  }
}

export default AddBookingForm;
