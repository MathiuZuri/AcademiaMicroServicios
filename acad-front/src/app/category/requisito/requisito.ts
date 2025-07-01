import { Component, Input, OnInit } from '@angular/core';
import { CommonModule, NgFor } from '@angular/common';
import {RequisitoModel} from '../models/requisito-model';

@Component({
  selector: 'app-apoderado',
  standalone: true,
  imports: [CommonModule, NgFor],
  templateUrl: './requisito.html',
  styleUrl: './requisito.scss'
})
export class Requisito implements OnInit {

  @Input() requisitos: RequisitoModel[] = [];

  ngOnInit(): void {
    console.log("=======>> Lista de requisitos:", this.requisitos);
  }
}
