import styles from '../../styles/model.module.css';
import React, { useState } from "react";

const surveyJson = {
  elements: [{
    name: "FirstName",
    title: "Enter your first name:",
    type: "text"
  }, {
    name: "LastName",
    title: "Enter your last name:",
    type: "text"
  }]
};

function MyInput({title}) {
    return (
        <label> {title}: <input name="myInput" /></label>
    )
}

function MyButton({text}) {
    return (
      <button>{text}</button>
    );
}

function MyExerciseInput() {
    return (
        <div>
            <MyInput title={"Nombre"}/>
            <MyInput title={"Duracion"}/>
            <MyInput title={"Series"}/>
            <MyInput title={"Repeticiones"}/>
            <MyInput title={"Peso"}/>
            <MyInput title={"Porcentaje"}/>
        </div>
    )
}

function ExerciseBlock() {
    const [inputList, setInputList] = useState([]);

    const onAddBtnClick = event => {
        setInputList(inputList.concat(<MyExerciseInput />));
    };

    return(
        <div className={styles.exercise}>
            <MyExerciseInput />
            {inputList}
        <button onClick={onAddBtnClick}>Add input</button>
        </div>
    )
}

export function MyForm() {
    return (
        <>
        <h1>Clase</h1>
        <MyInput title={"Tipo"}/>
        <MyInput title={"Nombre"}/>
        <h1>Ejercicios</h1>
        <ExerciseBlock />
        <MyButton text={"Guardar"} />
        </>
    )
}
