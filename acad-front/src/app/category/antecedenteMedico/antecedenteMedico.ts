import { Component, Input, OnInit } from '@angular/core';
import { CommonModule, NgFor } from '@angular/common';
import {ApoderadoModel} from '../models/apoderado-model';
import {AntecedenteMedicoModel} from '../models/antedecedente-medico-model';

@Component({
  selector: 'app-apoderado',
  standalone: true,
  imports: [CommonModule, NgFor],
  templateUrl: './antecedenteMedico.html',
  styleUrl: './antecedenteMedico.scss'
})
export class AntecedenteMedico implements OnInit {

  @Input() antecedentesMedicos: AntecedenteMedicoModel[] = [];

  ngOnInit(): void {
    console.log("=======>> Lista de antecedentes medicos:", this.antecedentesMedicos);
  }
}
