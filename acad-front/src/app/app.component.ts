import {Component} from '@angular/core';
import {RouterOutlet} from '@angular/router';

import {ApoderadoService} from './core/service/apoderado/apoderado.service';
import {Apoderado} from './category/apoderado/apoderado';
import {RequisitoService} from './core/service/requisito/requisito.service';
import {AntecedenteMedicoService} from './core/service/antecedenteMedico/antecedente-medico.service';
import {MatriculaService} from './core/service/matricula/matricula.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, Apoderado],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'acad-front';

  constructor(private apoderadoService: ApoderadoService,
              private requisitoService: RequisitoService,
              private antecedenteMedicoService: AntecedenteMedicoService,
              private matriculaService: MatriculaService) {
    this.apoderadoService.getApoderados().subscribe(response=>{
      console.log(response);
    });
    this.requisitoService.getRequisitos().subscribe(response=>{
      console.log(response);
    });
    this.antecedenteMedicoService.getAntecedentesMedicos().subscribe(response=>{
      console.log(response);
    });
    this.matriculaService.getMatriculas().subscribe(response=>{
      console.log(response);
    })
  }




  //protected readonly getEnabledCategories = getEnabledCategories;
  //categories!: import("D:/Proyecto2Modelo1.0/acad-front/src/app/category/models/category-model").CategoryModel[];
}
