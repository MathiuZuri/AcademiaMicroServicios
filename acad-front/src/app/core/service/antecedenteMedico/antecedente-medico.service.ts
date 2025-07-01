import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {resources} from '../../resources/resources';


@Injectable({providedIn: 'root'})
export class AntecedenteMedicoService {
  constructor(private http: HttpClient) {
  }

  getAntecedentesMedicos(): Observable<any[]> {
    return this.http.get<any[]>(resources.antecedenteMedicos.antecedenteMedico); // Se agregará la baseUrl por el interceptor
  }



}
