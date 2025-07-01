 // Ajusta la ruta si es necesario

import {Requisito} from '../requisito/requisito';

 export class MatriculaModel {
  idMatricula?: number;
  planAcademico?: string;
  institucion?: string;
  usuario?: string;
  codigoMatricula?: string;
  nivel?: string;
  idRequisitos?: number;
  requisitos?: Requisito;
}
