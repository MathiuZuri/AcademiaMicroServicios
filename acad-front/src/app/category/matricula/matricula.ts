import { Component, Input, OnInit } from '@angular/core';
import { CommonModule, NgFor } from '@angular/common';
import {ApoderadoModel} from '../models/apoderado-model';
import {AntecedenteMedicoModel} from '../models/antedecedente-medico-model';
import {MatriculaModel} from '../models/matricula-model';

@Component({
  selector: 'app-apoderado',
  standalone: true,
  imports: [CommonModule, NgFor],
  templateUrl: './matricula.html',
  styleUrl: './matricula.scss'
})
export class Matricula implements OnInit {

  @Input() matriculas: MatriculaModel[] = [];

  ngOnInit(): void {
    console.log("=======>> Lista de matriculas:", this.matriculas);
  }
}
