export class Response {
  severity: string;
  detail: string;
  responseObject: any;

  constructor(severity: string, detail: string, responseObject: any) {
    this.severity = severity;
    this.detail = detail;
    this.responseObject = responseObject;
  }
}
