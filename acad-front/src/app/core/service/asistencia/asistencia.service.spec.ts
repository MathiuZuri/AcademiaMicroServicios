import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { AsistenciaService } from './asistencia.service';
import { resources } from '../../resources/resources';
import { AsistenciaModel } from '../../../category/models/asistencia-model';

describe('AsistenciaService', () => {
  let service: AsistenciaService;
  let httpMock: HttpTestingController;
  const baseUrl = resources.asistencias.asistencia;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [AsistenciaService]
    });
    service = TestBed.inject(AsistenciaService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpMock.verify();
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should get all asistencias', () => {
    const dummy: AsistenciaModel[] = [
      { idAsistencia: 1, estadoAsistencia: 'Presente' },
      { idAsistencia: 2, estadoAsistencia: 'Ausente' }
    ];

    service.getAsistencias().subscribe((list) => {
      expect(list.length).toBe(2);
      expect(list).toEqual(dummy);
    });

    const req = httpMock.expectOne(baseUrl);
    expect(req.request.method).toBe('GET');
    req.flush(dummy);
  });

  it('should get asistencia by id', () => {
    const mock: AsistenciaModel = { idAsistencia: 5, estadoAsistencia: 'Tarde' };

    service.getById$(5).subscribe((item) => {
      expect(item).toEqual(mock);
    });

    const req = httpMock.expectOne(`${baseUrl}/5`);
    expect(req.request.method).toBe('GET');
    req.flush(mock);
  });

  it('should create an asistencia', () => {
    const nuevo: AsistenciaModel = { estadoAsistencia: 'Presente' };

    service.create$(nuevo).subscribe((res) => {
      expect(res).toEqual(nuevo);
    });

    const req = httpMock.expectOne(baseUrl);
    expect(req.request.method).toBe('POST');
    expect(req.request.body).toEqual(nuevo);
    req.flush(nuevo);
  });

  it('should update an asistencia', () => {
    const actualizado: AsistenciaModel = { idAsistencia: 3, estadoAsistencia: 'Justificado' };

    service.update$(3, actualizado).subscribe((res) => {
      expect(res).toEqual(actualizado);
    });

    const req = httpMock.expectOne(`${baseUrl}/3`);
    expect(req.request.method).toBe('PUT');
    expect(req.request.body).toEqual(actualizado);
    req.flush(actualizado);
  });

  it('should delete an asistencia', () => {
    service.delete$(7).subscribe((res) => {
      expect(res).toBeNull();
    });

    const req = httpMock.expectOne(`${baseUrl}/7`);
    expect(req.request.method).toBe('DELETE');
    req.flush(null);
  });
});
