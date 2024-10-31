/** @format */

import { Col, Row, Input, Button, Select, Tag } from "antd";
import Todo from "../Todo";
import { useDispatch, useSelector } from "react-redux";
import { addTodo } from "../../redux/actions";
import { v4 as uuidv4 } from "uuid";
import { useState } from "react";
import {
  searchTextSelector,
  todoListSelector,
  todosRemaining,
} from "../../redux/selectors";

export default function TodoList() {
  const [todoName, setTodoName] = useState("");
  const [prioriry, setPriority] = useState("Medium");
  const dispatch = useDispatch();
  const handleEventHandler = () => {
    dispatch(
      addTodo({
        id: uuidv4(),
        name: todoName,
        prioriry: prioriry,
        completed: false,
      })
    );
    setTodoName("");
    setPriority("Medium");
  };
  const handleInputChange = (e) => {
    setTodoName(e.target.value);
  };

  const handlePriority = (value) => {
    setPriority(value);
  };

  // const searchText = useSelector(searchTextSelector);

  const todoList = useSelector(todosRemaining);
  // console.log({ todoList, searchText });
  return (
    <Row style={{ height: "calc(100% - 40px)" }}>
      <Col span={24} style={{ height: "calc(100% - 40px)", overflowY: "auto" }}>
        {todoList.map((todo) => (
          <Todo key={todo.id} name={todo.name} prioriry={todo.prioriry} />
        ))}
      </Col>
      <Col span={24}>
        <Input.Group style={{ display: "flex" }} compact>
          <Input value={todoName} onChange={handleInputChange} />
          <Select
            defaultValue="Medium"
            value={prioriry}
            onChange={handlePriority}
          >
            <Select.Option value="High" label="High">
              <Tag color="red">High</Tag>
            </Select.Option>
            <Select.Option value="Medium" label="Medium">
              <Tag color="blue">Medium</Tag>
            </Select.Option>
            <Select.Option value="Low" label="Low">
              <Tag color="gray">Low</Tag>
            </Select.Option>
          </Select>
          <Button type="primary" onClick={handleEventHandler}>
            Add
          </Button>
        </Input.Group>
      </Col>
    </Row>
  );
}
