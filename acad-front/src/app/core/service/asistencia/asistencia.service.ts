import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { resources } from '../../resources/resources';
import { AsistenciaModel } from '../../../category/models/asistencia-model';

@Injectable({ providedIn: 'root' })
export class AsistenciaService {

  constructor(private http: HttpClient) {}

  getAsistencias(): Observable<AsistenciaModel[]> {
    return this.http.get<AsistenciaModel[]>(resources.asistencias.asistencia);
  }

  getById$(id: number): Observable<AsistenciaModel> {
    return this.http.get<AsistenciaModel>(`${resources.asistencias.asistencia}/${id}`);
  }

  create$(data: AsistenciaModel): Observable<AsistenciaModel> {
    return this.http.post<AsistenciaModel>(resources.asistencias.asistencia, data);
  }

  update$(id: number, data: AsistenciaModel): Observable<AsistenciaModel> {
    return this.http.put<AsistenciaModel>(`${resources.asistencias.asistencia}/${id}`, data);
  }

  delete$(id: number): Observable<void> {
    return this.http.delete<void>(`${resources.asistencias.asistencia}/${id}`);
  }
}
